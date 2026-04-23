package com.wishlist.service.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class WishlistResponseDto {

    private Integer wishlistId;
    private LocalDate addedDate;

    private UserDto user;
    private EventDto event;
}