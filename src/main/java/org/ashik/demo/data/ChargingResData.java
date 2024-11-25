package org.ashik.demo.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChargingResData {
    private int statusCode;
    private String message;
    private String transactionId;
    private String operator;
    private String shortCode;
    private String msisdn;
    private String chargeCode;
}
