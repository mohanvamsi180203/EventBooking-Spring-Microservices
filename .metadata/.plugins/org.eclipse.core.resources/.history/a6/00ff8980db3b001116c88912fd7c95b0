package com.search.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.search.service.dto.VenueDto;

@FeignClient(name = "VENUE-SERVICE")
public interface VenueClient {

    @GetMapping("/api/venue/get/{id}")
    VenueDto getById(@PathVariable("id") Integer id);
}