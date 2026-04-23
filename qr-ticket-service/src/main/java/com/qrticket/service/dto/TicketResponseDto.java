package com.qrticket.service.dto;

import java.time.LocalDateTime;

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
    private LocalDateTime generatedAt;
    
    private String eventName;
    private String city;
    private String category;
    private String eventDate;
}