package com.recommendation.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.recommendation.service.dto.BookingDto;

@FeignClient(name = "BOOKING-SERVICE")
public interface BookingClient {

    @GetMapping("/api/booking/getByUser/{userId}")
    List<BookingDto> getByUser(@PathVariable Integer userId);
}