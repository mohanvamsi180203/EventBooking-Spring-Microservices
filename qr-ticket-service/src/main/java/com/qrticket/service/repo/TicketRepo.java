package com.qrticket.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrticket.service.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {

    Ticket findByBookingId(Integer bookingId);

    Ticket findByQrCodeText(String qrCodeText);
}