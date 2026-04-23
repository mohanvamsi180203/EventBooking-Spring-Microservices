package com.user.service.dto;

import lombok.Data;

@Data
public class AuthDto {

    private Integer authId;
    private String username;
    private String email;
    private String password;
    private String role;
}