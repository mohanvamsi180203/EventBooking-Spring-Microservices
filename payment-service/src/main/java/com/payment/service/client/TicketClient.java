package com.payment.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.payment.service.dto.TicketResponseDto;

@FeignClient(name = "QR-TICKET-SERVICE")
public interface TicketClient {

    @PostMapping("/api/ticket/generate/{bookingId}")
    TicketResponseDto generateTicket(@PathVariable("bookingId") Integer bookingId);
}