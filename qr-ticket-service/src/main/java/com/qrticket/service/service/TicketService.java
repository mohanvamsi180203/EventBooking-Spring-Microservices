package com.qrticket.service.service;

import java.util.List;

import com.qrticket.service.dto.TicketResponseDto;

public interface TicketService {

    TicketResponseDto generateTicket(Integer bookingId);

    TicketResponseDto getByBooking(Integer bookingId);

    TicketResponseDto verifyTicket(String qrCodeText);

    List<TicketResponseDto> viewAll();
}