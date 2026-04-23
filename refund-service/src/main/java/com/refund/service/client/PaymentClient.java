package com.refund.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.refund.service.dto.PaymentDto;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentClient {

    @GetMapping("/api/payment/getByBooking/{bookingId}")
    PaymentDto getByBooking(@PathVariable("bookingId") Integer bookingId);
}