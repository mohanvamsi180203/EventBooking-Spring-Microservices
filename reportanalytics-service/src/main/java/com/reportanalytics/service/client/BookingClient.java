package com.reportanalytics.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.reportanalytics.service.dto.BookingDto;

@FeignClient(name = "BOOKING-SERVICE")
public interface BookingClient {

    @GetMapping("/api/booking/view")
    List<BookingDto> viewAll();
}
