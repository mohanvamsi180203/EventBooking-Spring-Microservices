package com.payment.service.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TicketResponseDto {

    private Integer ticketId;
    private Integer bookingId;
    private Integer userId;
    private Integer eventId;
    private String qrCodeText;
    private String qrImagePath;
    private String ticketStatus;
    private String eventName;
    private String category;
    private String city;
    private String eventDate;
}