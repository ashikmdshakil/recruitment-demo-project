package org.ashik.demo.service;

import jakarta.annotation.PostConstruct;
import org.ashik.demo.data.ContentResponseData;
import org.ashik.demo.model.Inbox;
import org.ashik.demo.repository.InboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ContentService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private InboxRepository inboxRepository;

    @Autowired
    private KeywordValidationService keywordValidationService;

    @Autowired
    private ChargingService chargingService;

    @PostConstruct
    public void fetchAndSaveContents() {
        String url = "http://demo.webmanza.com/a55dbz923ace647v/api/v1.0/services/content";

        try {
            // Fetch data from API
            ContentResponseData responseData = fetchContents(url);

            if (responseData != null && responseData.getContents() != null) {
                // Map response to Inbox entities
                List<Inbox> inboxEntries = mapContentsToInbox(responseData);

                // Save entities to the database
                inboxRepository.saveAll(inboxEntries);

                inboxEntries.forEach(inbox -> {
                    try {
                        // Step 1: Validate the keyword
                        boolean isKeywordValid = keywordValidationService.validateKeyword(inbox.getTransactionId(),
                                inbox.getKeyword(), inbox.getMsisdn(), inbox.getOperator(), inbox.getShortCode(),
                                inbox.getGameName()
                        );

                        if (!isKeywordValid) {
                            updateInboxStatus(inbox, "F"); // Invalid keyword, set status to 'F'
                        }

                        // Step 2: Process charging
                        chargingService.processCharging(inbox.getId());
                    } catch (Exception e) {
                        // Log the error and mark the inbox entry as failed
                        System.err.println("Error processing inbox entry ID " + inbox.getId() + ": " + e.getMessage());
                        updateInboxStatus(inbox, "F");
                    }
                });

                System.out.println("Contents saved to the database successfully.");
            }
        } catch (Exception e) {
            System.err.println("Error fetching or saving contents: " + e.getMessage());
        }
    }

    private ContentResponseData fetchContents(String url) {
        try {
            return restTemplate.getForObject(url, ContentResponseData.class);
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling API: " + e.getMessage(), e);
        }
    }

    private List<Inbox> mapContentsToInbox(ContentResponseData responseData) {
        return responseData.getContents().stream().map(content -> {
            Inbox inbox = new Inbox();
            inbox.setTransactionId(content.getTransactionId());
            inbox.setOperator(content.getOperator());
            inbox.setShortCode(content.getShortCode());
            inbox.setMsisdn(content.getMsisdn());
            inbox.setSms(content.getSms());
            inbox.setStatus("N"); // Initial status as 'N'
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
            String[] parts = sms.split(" ", 3); // Split SMS into at most 3 parts
            if (parts.length > 0) {
                inbox.setKeyword(parts[0]); // First part is the keyword
            }
            if (parts.length > 1) {
                inbox.setGameName(parts[1]); // Second part is the game name
            }
        }
    }
}