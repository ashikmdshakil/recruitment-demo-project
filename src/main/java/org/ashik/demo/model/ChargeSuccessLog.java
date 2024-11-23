package org.ashik.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "charge_success_log")
public class ChargeSuccessLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sms_id")
    private Integer smsId;

    @Column(name = "transaction_id", length = 100)
    private String transactionId;

    @Column(name = "operator", length = 50)
    private String operator;

    @Column(name = "short_code", length = 20)
    private String shortCode;

    @Column(name = "msisdn", length = 20)
    private String msisdn;

    @Column(name = "keyword", length = 50)
    private String keyword;

    @Column(name = "game_name", length = 50)
    private String gameName;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}

