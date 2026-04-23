package com.refund.service.dto;

import lombok.Data;

@Data
public class BookingDto {

    private Integer bookingId;
    private Integer userId;
    private Integer eventId;
    private Integer quantity;
    private Double totalAmount;
    private String bookingStatus;
}