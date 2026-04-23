package com.qrticket.service.dto;

import lombok.Data;

@Data
public class EventDto {

    private Integer eventId;
    private String eventName;
    private String category;
    private String city;
    private String eventDate;
}