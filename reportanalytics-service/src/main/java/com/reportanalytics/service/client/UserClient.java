package com.reportanalytics.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.reportanalytics.service.dto.UserDto;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {

    @GetMapping("/api/user/view")
    List<UserDto> viewAll();
}