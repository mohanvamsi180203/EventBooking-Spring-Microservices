package com.wishlist.service.dto;

import lombok.Data;

@Data
public class UserDto {

    private Integer userId;
    private Integer authId;
    private String name;
    private String email;
    private String phone;
    private String city;
    private String status;
}