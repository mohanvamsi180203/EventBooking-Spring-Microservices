package com.organizer.dashboard.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.organizer.dashboard.service.dto.UserDto;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {

    @GetMapping("/api/user/getEntity/{id}")
    UserDto getUserEntityById(@PathVariable Integer id);
}