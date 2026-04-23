package com.wishlist.service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wishlist.service.entity.Wishlist;

public interface WishlistRepo extends JpaRepository<Wishlist, Integer> {

    List<Wishlist> findByUserId(Integer userId);

    List<Wishlist> findByEventId(Integer eventId);

    Wishlist
    findByUserIdAndEventId(Integer userId, Integer eventId);
}