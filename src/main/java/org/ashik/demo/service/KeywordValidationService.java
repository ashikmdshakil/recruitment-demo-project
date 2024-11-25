package org.ashik.demo.service;

import org.ashik.demo.data.KeywordValidationReqData;
import org.ashik.demo.data.KeywordValidationResData;
import org.ashik.demo.repository.KeywordDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KeywordValidationService {

    private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private KeywordDetailsRepository keywordDetailsRepository;

    public boolean validateKeyword(String transactionId, String keyword, String msisdn, String operator,
                                   String shortCode, String gameName) {
        String url = "http://demo.webmanza.com/a55dbz923ace647v/api/v1.0/services/unlockCode";

        if (keyword == null || keyword.isEmpty()) {
            return false;
        }
        if (!keywordDetailsRepository.existsByKeyword(keyword)) {
            return false;
        }

        KeywordValidationReqData request =
                new KeywordValidationReqData(transactionId, keyword, msisdn, operator, shortCode, gameName);

        try {
            // Set headers if needed
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            HttpEntity<KeywordValidationReqData> entity = new HttpEntity<>(request, headers);

            // Make POST request and map response
            ResponseEntity<KeywordValidationResData> response = restTemplate.exchange(
                    url, HttpMethod.POST, entity, KeywordValidationResData.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                KeywordValidationResData responseBody = response.getBody();
                if (responseBody != null && responseBody.getStatusCode() == 200) {
                    System.out.println("Validation successful: " + responseBody);
                    return true;
                } else {
                    System.out.println("Validation failed: " + responseBody);
                    return false;
                }
            } else {
                System.err.println("Failed to validate keyword: " + response.getStatusCode());
                return false;
            }
        } catch (Exception e) {
            System.err.println("Keyword validation exception: " + e.getMessage());
            return false;
        }
    }
}
