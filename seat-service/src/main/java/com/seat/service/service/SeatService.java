package com.seat.service.service;

import java.util.List;

import com.seat.service.dto.SeatCreateRequest;
import com.seat.service.entity.Seat;

public interface SeatService {

    List<Seat> createSeats(SeatCreateRequest request);

    List<Seat> getSeatsByEvent(Integer eventId);

    List<Seat> lockSeats(Integer userId, List<Integer> seatIds);

    List<Seat> confirmSeats(List<Integer> seatIds);

    List<Seat> releaseSeats(List<Integer> seatIds);
}