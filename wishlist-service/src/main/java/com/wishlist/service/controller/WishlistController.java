package com.wishlist.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wishlist.service.dto.WishlistResponseDto;
import com.wishlist.service.entity.Wishlist;
import com.wishlist.service.service.WishlistService;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/add")
    public WishlistResponseDto addToWishlist(@RequestBody Wishlist wishlist) {
        return wishlistService.addToWishlist(wishlist);
    }

    @DeleteMapping("/remove/{wishlistId}")
    public String removeFromWishlist(@PathVariable Integer wishlistId) {
        return wishlistService.removeFromWishlist(wishlistId);
    }

    @GetMapping("/view")
    public List<WishlistResponseDto> viewAll() {
        return wishlistService.viewAll();
    }

    @GetMapping("/get/{id}")
    public WishlistResponseDto getById(@PathVariable Integer id) {
        return wishlistService.getById(id);
    }

    @GetMapping("/getByUser/{userId}")
    public List<WishlistResponseDto> getByUser(@PathVariable Integer userId) {
        return wishlistService.getByUser(userId);
    }

    @GetMapping("/getByEvent/{eventId}")
    public List<WishlistResponseDto> getByEvent(@PathVariable Integer eventId) {
        return wishlistService.getByEvent(eventId);
    }
}