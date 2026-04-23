package com.seat.service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seat.service.entity.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer> {

    List<Seat> findByEventId(Integer eventId);

    List<Seat> findByEventIdAndStatus(Integer eventId, String status);
}