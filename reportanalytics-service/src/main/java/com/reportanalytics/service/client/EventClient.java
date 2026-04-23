package com.reportanalytics.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.reportanalytics.service.dto.EventDto;

@FeignClient(name = "EVENT-SERVICE")
public interface EventClient {

    @GetMapping("/api/event/view")
    List<EventDto> viewAll();
}