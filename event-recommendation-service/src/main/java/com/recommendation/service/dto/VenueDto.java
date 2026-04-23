package com.recommendation.service.dto;

import lombok.Data;

@Data
public class VenueDto {

    private Integer venueId;
    private String venueName;
    private String location;
    private Integer capacity;
    private String venueType;
}