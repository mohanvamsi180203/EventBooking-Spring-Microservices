package com.qrticket.service.dto;

import lombok.Data;

@Data
public class BookingDto {

    private Integer bookingId;
    private Integer userId;
    private Integer eventId;
    private Integer quantity;
    private String bookingStatus;
}