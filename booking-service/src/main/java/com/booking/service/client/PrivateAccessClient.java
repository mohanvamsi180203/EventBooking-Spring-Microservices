package com.booking.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.booking.service.dto.PrivateAccessDto;

@FeignClient(name = "PRIVATE-ACCESS-SERVICE")
public interface PrivateAccessClient {

    @GetMapping("/api/privateaccess/getByEventAndUser/{eventId}/{userId}")
    PrivateAccessDto getByEventAndUser(
            @PathVariable("eventId") Integer eventId,
            @PathVariable("userId") Integer userId);
}