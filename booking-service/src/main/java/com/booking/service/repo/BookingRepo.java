package com.booking.service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.service.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer> {

    List<Booking> findByUserId(Integer userId);

    List<Booking> findByEventId(Integer eventId);

    List<Booking> findByBookingStatus(String bookingStatus);
    
    
}