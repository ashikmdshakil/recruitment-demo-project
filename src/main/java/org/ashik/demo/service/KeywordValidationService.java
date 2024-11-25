package org.ashik.demo.service;

public interface KeywordValidationService {
    boolean validateKeyword(String transactionId, String keyword, String msisdn, String operator,
                            String shortCode, String gameName);
}
