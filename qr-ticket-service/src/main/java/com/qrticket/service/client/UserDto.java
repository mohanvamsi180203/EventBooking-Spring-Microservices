package com.qrticket.service.client;

import lombok.Data;

@Data
public class UserDto {

    private Integer userId;
    private String name;
    private String email;
}