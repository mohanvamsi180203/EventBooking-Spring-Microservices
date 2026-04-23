package com.qrticket.service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    private Integer bookingId;
    private Integer userId;
    private Integer eventId;
    private String qrCodeText;
    private String qrImagePath;
    private String ticketStatus;
    private LocalDateTime generatedAt;
}