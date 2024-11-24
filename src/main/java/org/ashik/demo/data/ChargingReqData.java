package org.ashik.demo.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChargingReqData {
    private String msisdn;
    private String chargeCode;
    private Double amount;
    private String transactionId;
}
