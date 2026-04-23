package com.event.service.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class EventResponseDto {

    private Integer eventId;
    private String eventName;
    private String category;
    private String description;
    private LocalDate eventDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String eventType;
    private Double ticketPrice;
    private Integer totalTickets;
    private Integer availableTickets;
    private String status;

    private VenueDto venue;
    private UserDto organizer;
}