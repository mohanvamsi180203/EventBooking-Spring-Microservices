package com.qrticket.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.qrticket.service.dto.EventDto;

@FeignClient(name = "EVENT-SERVICE")
public interface EventClient {

    @GetMapping("/api/event/getEntity/{id}")
    EventDto getById(@PathVariable("id") Integer id);
}