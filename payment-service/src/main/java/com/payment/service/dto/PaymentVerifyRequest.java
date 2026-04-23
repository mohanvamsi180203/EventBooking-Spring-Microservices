package com.payment.service.dto;

import lombok.Data;

@Data
public class PaymentVerifyRequest {

    private String razorpayOrderId;
    private String razorpayPaymentId;
}