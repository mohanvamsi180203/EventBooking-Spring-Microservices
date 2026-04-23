package com.reportanalytics.service.dto;

import lombok.Data;

@Data
public class EventDto {

    private Integer eventId;
    private String category;
    private String city;
    private String eventType;
    private String eventName;
}