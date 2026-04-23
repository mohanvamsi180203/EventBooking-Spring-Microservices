package com.booking.service.dto;

import lombok.Data;

@Data
public class PrivateAccessDto {

    private Integer accessId;
    private Integer eventId;
    private Integer userId;
    private String invitationStatus;
}