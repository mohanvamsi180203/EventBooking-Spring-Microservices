package com.recommendation.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.recommendation.service.dto.WishlistDto;

@FeignClient(name = "WISHLIST-SERVICE")
public interface WishlistClient {

    @GetMapping("/api/wishlist/getByUser/{userId}")
    List<WishlistDto> getByUser(@PathVariable Integer userId);
}