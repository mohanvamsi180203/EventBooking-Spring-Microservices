package com.event.service.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventId;

    private String eventName;
    private String category;
    private String description;
    private LocalDate eventDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer venueId;
    private Integer organizerId;
    private String eventType;
    private Double ticketPrice;
    private Integer totalTickets;
    private Integer availableTickets;
    private String status;
    private Boolean hasSeats;
}