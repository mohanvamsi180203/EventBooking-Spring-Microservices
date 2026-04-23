package com.notification.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.notification.service.dto.UserDto;

@FeignClient(name = "USER-SERVICE", url = "http://localhost:8082")
public interface UserClient {

    @GetMapping("/api/user/getEntity/{id}")
    UserDto getUserEntityById(@PathVariable("id") Integer id);
}