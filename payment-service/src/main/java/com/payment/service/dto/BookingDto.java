package com.payment.service.dto;

import java.util.List;

import lombok.Data;

@Data
public class BookingDto {

    private Integer bookingId;
    private Integer quantity;
    private Double totalAmount;
    private String bookingStatus;
    private List<Integer> seatIds;
}