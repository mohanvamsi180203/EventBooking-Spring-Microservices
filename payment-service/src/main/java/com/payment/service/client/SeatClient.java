package com.payment.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.payment.service.dto.SeatDto;

@FeignClient(name = "SEAT-SERVICE")
public interface SeatClient {

    @PutMapping("/api/seat/confirm")
    List<SeatDto> confirmSeats(
            @RequestBody List<Integer> seatIds);
}