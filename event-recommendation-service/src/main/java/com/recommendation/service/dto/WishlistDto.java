package com.recommendation.service.dto;


import java.time.LocalDate;

import lombok.Data;
@Data
public class WishlistDto {

    private Integer wishlistId;
    private LocalDate addedDate;

    private UserDto user;
    private EventDto event;
}