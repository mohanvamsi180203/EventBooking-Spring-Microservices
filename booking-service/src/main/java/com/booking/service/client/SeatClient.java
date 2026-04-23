package com.booking.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.booking.service.dto.SeatDto;

@FeignClient(name = "SEAT-SERVICE")
public interface SeatClient {

    @PutMapping("/api/seat/lock/{userId}")
    List<SeatDto> lockSeats(
            @PathVariable("userId") Integer userId,
            @RequestBody List<Integer> seatIds);

    @PutMapping("/api/seat/confirm")
    List<SeatDto> confirmSeats(
            @RequestBody List<Integer> seatIds);

    @PutMapping("/api/seat/release")
    List<SeatDto> releaseSeats(
            @RequestBody List<Integer> seatIds);
}