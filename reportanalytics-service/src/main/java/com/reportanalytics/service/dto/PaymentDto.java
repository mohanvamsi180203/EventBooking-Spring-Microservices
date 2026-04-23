package com.reportanalytics.service.dto;

import lombok.Data;

@Data
public class PaymentDto {

    private Integer paymentId;
    private Double amount;
    private String paymentStatus;
}