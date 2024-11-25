package org.ashik.demo.serviceImpl;

import org.ashik.demo.data.KeywordValidationReqData;
import org.ashik.demo.data.KeywordValidationResData;
import org.ashik.demo.repository.KeywordDetailsRepository;
import org.ashik.demo.service.KeywordValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KeywordValidationServiceImpl implements KeywordValidationService {

    @Value("${api.base.url}")
    private String apiBaseUrl;
    private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private KeywordDetailsRepository keywordDetailsRepository;

    @Override
    public boolean validateKeyword(String transactionId, String keyword, String msisdn, String operator,
                                   String shortCode, String gameName) {

        String unlock_code_url = apiBaseUrl + "/services/unlockCode";

        if (keyword == null || keyword.isEmpty()) {
            return false;
        }

        if (!keywordDetailsRepository.existsByKeyword(keyword)) {
            return false;
        }

        KeywordValidationReqData request =
                new KeywordValidationReqData(transactionId, keyword, msisdn, operator, shortCode, gameName);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            HttpEntity<KeywordValidationReqData> entity = new HttpEntity<>(request, headers);

            // POST request for keyword validation
            ResponseEntity<KeywordValidationResData> response = restTemplate.exchange(
                    unlock_code_url, HttpMethod.POST, entity, KeywordValidationResData.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                KeywordValidationResData responseBody = response.getBody();
                if (responseBody != null && responseBody.getStatusCode() == 200) {
                    System.out.println("VALIDATION SUCCESSFUL: " + responseBody);
                    return true;
                } else {
                    System.out.println("VALIDATION FAILED: " + responseBody);
                    return false;
                }
            } else {
                System.err.println("FAILED TO VALIDATE KEYWORD: " + response.getStatusCode());
                return false;
            }
        } catch (Exception e) {
            System.err.println("KEYWORD VALIDATION EXCEPTION: " + e.getMessage());
            return false;
        }
    }
}
