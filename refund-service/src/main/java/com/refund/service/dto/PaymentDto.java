package com.refund.service.dto;

import lombok.Data;

@Data
public class PaymentDto {

    private Integer paymentId;
    private Integer bookingId;
    private Double amount;
    private String paymentStatus;
}