package com.payment.service.service;

import java.util.List;

import com.payment.service.dto.PaymentVerifyRequest;
import com.payment.service.entity.Payment;

public interface PaymentService {

    String createOrder(Integer bookingId) throws Exception;

    String verifyPayment(PaymentVerifyRequest request);

    List<Payment> viewAll();

    Payment getById(Integer id);
}