package com.organizer.dashboard.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.organizer.dashboard.service.dto.EventDto;

@FeignClient(name = "EVENT-SERVICE")
public interface EventClient {

    @GetMapping("/api/event/getByOrganizer/{organizerId}")
    List<EventDto> getByOrganizer(@PathVariable Integer organizerId);
}