package com.payment.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.payment.service.dto.BookingDto;

@FeignClient(name = "BOOKING-SERVICE")
public interface BookingClient {

    @GetMapping("/api/booking/get/{id}")
    BookingDto getById(@PathVariable("id") Integer id);

    @PutMapping("/api/booking/confirm/{bookingId}")
    BookingDto confirmBooking(@PathVariable("bookingId") Integer bookingId);
}