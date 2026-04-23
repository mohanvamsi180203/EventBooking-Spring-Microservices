
package com.event.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.event.service.dto.UserDto;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {

    @GetMapping("/api/user/get/{id}")
    UserDto getById(@PathVariable Integer id);
}
