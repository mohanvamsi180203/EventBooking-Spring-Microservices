package com.qrticket.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.qrticket.service.dto.BookingDto;

@FeignClient(name = "BOOKING-SERVICE")
public interface BookingClient {

    @GetMapping("/api/booking/getEntity/{id}")
    BookingDto getById(@PathVariable("id") Integer id);
}