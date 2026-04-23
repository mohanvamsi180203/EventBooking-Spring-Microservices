package com.refund.service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.refund.service.entity.Refund;

public interface RefundRepo extends JpaRepository<Refund, Integer> {

    List<Refund> findByUserId(Integer userId);

    List<Refund> findByRefundStatus(String refundStatus);

    Refund findByBookingId(Integer bookingId);
}