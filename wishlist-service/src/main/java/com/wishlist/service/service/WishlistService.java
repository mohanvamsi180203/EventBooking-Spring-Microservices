package com.wishlist.service.service;

import java.util.List;

import com.wishlist.service.dto.WishlistResponseDto;
import com.wishlist.service.entity.Wishlist;

public interface WishlistService {

    WishlistResponseDto addToWishlist(Wishlist wishlist);

    String removeFromWishlist(Integer wishlistId);

    List<WishlistResponseDto> viewAll();

    WishlistResponseDto getById(Integer id);

    List<WishlistResponseDto> getByUser(Integer userId);

    List<WishlistResponseDto> getByEvent(Integer eventId);
}