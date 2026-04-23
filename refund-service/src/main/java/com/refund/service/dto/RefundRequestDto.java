package com.refund.service.dto;

import lombok.Data;

@Data
public class RefundRequestDto {

    private Integer bookingId;
    private String refundReason;
}