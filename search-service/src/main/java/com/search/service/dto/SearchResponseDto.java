package com.search.service.dto;

import java.time.LocalDate;

import lombok.Data;

@Data

public class SearchResponseDto {

    private Integer eventId;
    private String eventName;
    private String category;
    private String city;
    private LocalDate eventDate;
    private Double ticketPrice;
    private String status;
    private String eventType;
}