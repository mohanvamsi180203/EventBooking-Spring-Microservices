package com.qrticket.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qrticket.service.dto.TicketResponseDto;
import com.qrticket.service.service.TicketService;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/generate/{bookingId}")
    public TicketResponseDto generateTicket(@PathVariable Integer bookingId) {
        return ticketService.generateTicket(bookingId);
    }

    @GetMapping("/getByBooking/{bookingId}")
    public TicketResponseDto getByBooking(@PathVariable Integer bookingId) {
        return ticketService.getByBooking(bookingId);
    }

    @PutMapping("/verify/{qrCodeText}")
    public TicketResponseDto verifyTicket(@PathVariable String qrCodeText) {
        return ticketService.verifyTicket(qrCodeText);
    }

    @GetMapping("/view")
    public List<TicketResponseDto> viewAll() {
        return ticketService.viewAll();
    }
}