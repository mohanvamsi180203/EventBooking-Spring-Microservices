package com.reportanalytics.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.reportanalytics.service.dto.RefundDto;

@FeignClient(name = "REFUND-SERVICE")
public interface RefundClient {

    @GetMapping("/api/refund/view")
    List<RefundDto> viewAll();
}