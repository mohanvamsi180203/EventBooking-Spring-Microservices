package com.seat.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seat.service.dto.SeatCreateRequest;
import com.seat.service.entity.Seat;
import com.seat.service.service.SeatService;

@RestController
@RequestMapping("/api/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @PostMapping("/create")
    public List<Seat> createSeats(
            @RequestBody SeatCreateRequest request) {

        return seatService.createSeats(request);
    }

    @GetMapping("/event/{eventId}")
    public List<Seat> getSeatsByEvent(
            @PathVariable Integer eventId) {

        return seatService.getSeatsByEvent(eventId);
    }

    @PutMapping("/lock/{userId}")
    public List<Seat> lockSeats(
            @PathVariable Integer userId,
            @RequestBody List<Integer> seatIds) {

        return seatService.lockSeats(userId, seatIds);
    }

    @PutMapping("/confirm")
    public List<Seat> confirmSeats(
            @RequestBody List<Integer> seatIds) {

        return seatService.confirmSeats(seatIds);
    }

    @PutMapping("/release")
    public List<Seat> releaseSeats(
            @RequestBody List<Integer> seatIds) {

        return seatService.releaseSeats(seatIds);
    }
}