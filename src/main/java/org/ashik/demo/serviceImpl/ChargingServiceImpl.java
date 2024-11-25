package org.ashik.demo.serviceImpl;

import jakarta.annotation.PostConstruct;
import org.ashik.demo.data.ChargingReqData;
import org.ashik.demo.data.ChargingResData;
import org.ashik.demo.model.ChargeConfig;
import org.ashik.demo.model.ChargeFailureLog;
import org.ashik.demo.model.ChargeSuccessLog;
import org.ashik.demo.model.Inbox;
import org.ashik.demo.repository.ChargeConfigRepository;
import org.ashik.demo.repository.ChargeFailureLogRepository;
import org.ashik.demo.repository.ChargeSuccessLogRepository;
import org.ashik.demo.repository.InboxRepository;
import org.ashik.demo.service.ChargingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ChargingServiceImpl implements ChargingService {

    @Value("${api.base.url}")
    private String apiBaseUrl;
    private String CHARGE_URL;
    private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private InboxRepository inboxRepository;
    @Autowired
    private ChargeConfigRepository chargeConfigRepository;
    @Autowired
    private ChargeSuccessLogRepository chargeSuccessLogRepository;
    @Autowired
    private ChargeFailureLogRepository chargeFailureLogRepository;

    @PostConstruct
    private void init() {
        CHARGE_URL = apiBaseUrl + "/services/charge";
    }

    @Override
    @Transactional
    public void performCharging(Integer inboxId) {
        // Fetch the inbox record
        Inbox inbox = inboxRepository.findById(inboxId)
                .orElseThrow(() -> new RuntimeException("INBOX RECORD NOT FOUND FOR ID: " + inboxId));

        // Retrieve charge configuration
        Optional<ChargeConfig> chargeConfigOpt = chargeConfigRepository.findByOperator(inbox.getOperator());
        if (chargeConfigOpt.isEmpty()) {
            updateInboxStatus(inbox, "F");
            logFailure(inbox, 400, "CHARGE CONFIGURATION NOT FOUND");
            return;
        }
        ChargeConfig chargeConfig = chargeConfigOpt.get();

        ChargingReqData chargingRequest = ChargingReqData.builder()
                .msisdn(inbox.getMsisdn())
                .chargeCode(chargeConfig.getChargeCode())
                .transactionId(inbox.getTransactionId())
                .shortCode(inbox.getShortCode())
                .operator(inbox.getOperator())
                .build();

        try {
            ChargingResData response = restTemplate.postForObject(CHARGE_URL, chargingRequest, ChargingResData.class);

            if (response != null && response.getStatusCode() == 200) {
                updateInboxStatus(inbox, "S");
                logSuccess(inbox);
            } else {
                updateInboxStatus(inbox, "F");
                logFailure(inbox, response.getStatusCode(), response.getMessage());
            }
        } catch (Exception e) {
            updateInboxStatus(inbox, "F");
            logFailure(inbox, 500, "ERROR WHILE CHARGING: " + e.getMessage());
        }
    }

    private void updateInboxStatus(Inbox inbox, String status) {
        inbox.setStatus(status);
        inbox.setUpdatedAt(LocalDateTime.now());
        inboxRepository.save(inbox);
    }

    private void logSuccess(Inbox inbox) {
        ChargeSuccessLog successLog = ChargeSuccessLog.builder()
                .smsId(inbox.getId())
                .transactionId(inbox.getTransactionId())
                .operator(inbox.getOperator())
                .shortCode(inbox.getShortCode())
                .msisdn(inbox.getMsisdn())
                .keyword(inbox.getKeyword())
                .gameName(inbox.getGameName())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        chargeSuccessLogRepository.save(successLog);
    }

    private void logFailure(Inbox inbox, int statusCode, String message) {
        ChargeFailureLog failureLog = ChargeFailureLog.builder()
                .smsId(inbox.getId())
                .transactionId(inbox.getTransactionId())
                .operator(inbox.getOperator())
                .shortCode(inbox.getShortCode())
                .msisdn(inbox.getMsisdn())
                .keyword(inbox.getKeyword())
                .gameName(inbox.getGameName())
                .statusCode(statusCode)
                .message(message)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        chargeFailureLogRepository.save(failureLog);
    }
}
