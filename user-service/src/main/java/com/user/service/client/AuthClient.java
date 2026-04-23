package com.user.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.dto.AuthDto;

@FeignClient(name = "AUTH-SERVICE")
public interface AuthClient {

    @GetMapping("/api/auth/get/{id}")
    AuthDto getById(@PathVariable Integer id);
}
