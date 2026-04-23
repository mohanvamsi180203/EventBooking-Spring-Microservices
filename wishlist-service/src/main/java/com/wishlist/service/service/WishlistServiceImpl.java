package com.wishlist.service.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wishlist.service.client.EventClient;
import com.wishlist.service.client.UserClient;
import com.wishlist.service.dto.EventDto;
import com.wishlist.service.dto.UserDto;
import com.wishlist.service.dto.WishlistResponseDto;
import com.wishlist.service.entity.Wishlist;
import com.wishlist.service.repo.WishlistRepo;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepo wishlistRepo;

    @Autowired
    private UserClient userClient;

    @Autowired
    private EventClient eventClient;

    @Override
    public WishlistResponseDto addToWishlist(Wishlist wishlist) {

        UserDto user = userClient.getUserEntityById(wishlist.getUserId());

        if(user == null) {
            throw new RuntimeException("User Not Found");
        }

        EventDto event = eventClient.getEventEntityById(wishlist.getEventId());

        if(event == null) {
            throw new RuntimeException("Event Not Found");
        }

        Wishlist existing = wishlistRepo.findByUserIdAndEventId(
                wishlist.getUserId(),
                wishlist.getEventId());

        if(existing != null) {
            throw new RuntimeException("Event Already Added To Wishlist");
        }

        wishlist.setAddedDate(LocalDate.now());

        Wishlist savedWishlist = wishlistRepo.save(wishlist);

        return mapWishlist(savedWishlist);
    }

    @Override
    public String removeFromWishlist(Integer wishlistId) {

        Wishlist wishlist = wishlistRepo.findById(wishlistId).orElse(null);

        if(wishlist == null) {
            throw new RuntimeException("Wishlist Item Not Found");
        }

        wishlistRepo.deleteById(wishlistId);

        return "Removed From Wishlist Successfully";
    }

    @Override
    public List<WishlistResponseDto> viewAll() {

        List<Wishlist> wishlists = wishlistRepo.findAll();

        return wishlists.stream().map(this::mapWishlist)
                .collect(Collectors.toList());
    }

    @Override
    public WishlistResponseDto getById(Integer id) {

        Wishlist wishlist = wishlistRepo.findById(id).orElse(null);

        return mapWishlist(wishlist);
    }

    @Override
    public List<WishlistResponseDto> getByUser(Integer userId) {

        List<Wishlist> wishlists = wishlistRepo.findByUserId(userId);

        return wishlists.stream().map(this::mapWishlist)
                .collect(Collectors.toList());
    }

    @Override
    public List<WishlistResponseDto> getByEvent(Integer eventId) {

        List<Wishlist> wishlists = wishlistRepo.findByEventId(eventId);

        return wishlists.stream().map(this::mapWishlist)
                .collect(Collectors.toList());
    }

    private WishlistResponseDto mapWishlist(Wishlist wishlist) {

        UserDto user = userClient.getUserEntityById(wishlist.getUserId());

        EventDto event = eventClient.getEventEntityById(wishlist.getEventId());

        WishlistResponseDto response = new WishlistResponseDto();

        response.setWishlistId(wishlist.getWishlistId());
        response.setAddedDate(wishlist.getAddedDate());

        response.setUser(user);
        response.setEvent(event);

        return response;
    }
}