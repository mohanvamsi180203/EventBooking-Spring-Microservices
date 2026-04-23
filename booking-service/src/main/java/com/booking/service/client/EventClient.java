package com.booking.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.booking.service.dto.EventDto;

@FeignClient(name = "EVENT-SERVICE")
public interface EventClient {

    @GetMapping("/api/event/getEntity/{id}")
    EventDto getEventEntityById(@PathVariable Integer id);

    @PutMapping("/api/event/reduceAvailableTickets/{id}/{tickets}")
    EventDto reduceAvailableTickets(
            @PathVariable Integer id,
            @PathVariable Integer tickets);

    @PutMapping("/api/event/increaseAvailableTickets/{id}/{tickets}")
    EventDto increaseAvailableTickets(
            @PathVariable Integer id,
            @PathVariable Integer tickets);
}