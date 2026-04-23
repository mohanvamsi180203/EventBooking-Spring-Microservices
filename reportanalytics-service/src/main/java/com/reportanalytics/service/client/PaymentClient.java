package com.reportanalytics.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.reportanalytics.service.dto.PaymentDto;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentClient {

    @GetMapping("/api/payment/view")
    List<PaymentDto> viewAll();
}