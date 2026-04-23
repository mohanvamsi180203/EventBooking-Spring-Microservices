package com.example.demo.dto;

import lombok.Data;

@Data
public class PrivateAccessResponseDto {

    private Integer accessId;
    private String invitationStatus;

    private UserDto user;
    private EventDto event;
}