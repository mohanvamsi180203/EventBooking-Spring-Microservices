package com.booking.service.dto;

import lombok.Data;

@Data
public class UserDto {

    private Integer userId;
    private Integer authId;
    private UserDto organizer;
    private String name;
    private String email;
    private String phone;
    private String city;
    private String status;
}