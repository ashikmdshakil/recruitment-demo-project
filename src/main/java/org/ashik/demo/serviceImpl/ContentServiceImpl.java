package org.ashik.demo.serviceImpl;

import jakarta.annotation.PostConstruct;
import org.ashik.demo.data.ContentResData;
import org.ashik.demo.model.Inbox;
import org.ashik.demo.repository.InboxRepository;
import org.ashik.demo.service.ChargingService;
import org.ashik.demo.service.ContentService;
import org.ashik.demo.service.KeywordValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
public class ContentServiceImpl implements ContentService {

    @Value("${api.base.url}")
    private String apiBaseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private InboxRepository inboxRepository;

    @Autowired
    private KeywordValidationService keywordValidationService;

    @Autowired
    private ChargingService chargingService;

    @Override
    @PostConstruct
    public void fetchAndSaveContents() {
        String content_url = apiBaseUrl + "/services/content";

        try {
            // Fetch data from API
            ContentResData responseData = fetchContents(content_url);

            if (responseData != null && responseData.getContents() != null) {
                List<Inbox> inboxEntries = mapContentsToInbox(responseData);

                // Save entities to the database
                inboxRepository.saveAll(inboxEntries);

                inboxEntries.parallelStream().forEach(inbox -> {
                    processInboxData(inbox);
                });

                System.out.println("CONTENTS SAVED TO THE DATABASE SUCCESSFULLY.");
            }
        } catch (Exception e) {
            System.err.println("ERROR FETCHING OR SAVING CONTENTS: " + e.getMessage());
        }
    }

    private void processInboxData(Inbox inbox) {
        try {
            boolean isKeywordValid = keywordValidationService.validateKeyword(inbox.getTransactionId(),
                    inbox.getKeyword(), inbox.getMsisdn(), inbox.getOperator(), inbox.getShortCode(),
                    inbox.getGameName()
            );

            //TODO: content status update not mentioned
            if (!isKeywordValid) {
                updateInboxStatus(inbox, "F"); // set content status to 'F' for failure
            } else {
                chargingService.performCharging(inbox.getId());
            }
        } catch (Exception e) {
            System.err.println("ERROR PROCESSING INBOX ENTRY ID " + inbox.getId() + ": " + e.getMessage());
        }
    }

    private ContentResData fetchContents(String url) {
        try {
            return restTemplate.getForObject(url, ContentResData.class);
        } catch (Exception e) {
            throw new RuntimeException("EXCEPTION WHILE CALLING API: " + e.getMessage(), e);
        }
    }

    private List<Inbox> mapContentsToInbox(ContentResData responseData) {
        return responseData.getContents().stream().map(content -> {
            Inbox inbox = new Inbox();
            inbox.setTransactionId(content.getTransactionId());
            inbox.setOperator(content.getOperator());
            inbox.setShortCode(content.getShortCode());
            inbox.setMsisdn(content.getMsisdn());
            inbox.setSms(content.getSms());
            inbox.setStatus("N"); // Initial status 'N'
            extractKeywordAndGameName(content.getSms(), inbox);
            return inbox;
        }).toList();
    }

    private void updateInboxStatus(Inbox inbox, String status) {
        inbox.setStatus(status);
        inboxRepository.save(inbox);
    }

    private void extractKeywordAndGameName(String sms, Inbox inbox) {
        if (sms != null && !sms.isEmpty()) {
            String[] parts = sms.split(" ", 3); // Splitting SMS into 3 parts
            if (parts.length > 0) {
                inbox.setKeyword(parts[0]); // First part is the keyword
            }
            if (parts.length > 1) {
                inbox.setGameName(parts[1]); // Second part is the game name
            }
        }
    }
}