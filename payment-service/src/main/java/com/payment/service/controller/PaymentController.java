package com.payment.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.service.dto.PaymentVerifyRequest;
import com.payment.service.entity.Payment;
import com.payment.service.repo.PaymentRepo;
import com.payment.service.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    
    @Autowired
    private PaymentRepo paymentRepo;

    
    @GetMapping("/getByBooking/{bookingId}")
    public Payment getByBooking(@PathVariable Integer bookingId) {
        return paymentRepo.findByBookingId(bookingId);
    }
    
    @PostMapping("/createOrder/{bookingId}")
    public String createOrder(@PathVariable Integer bookingId) throws Exception {
        return paymentService.createOrder(bookingId);
    }

    @PostMapping("/verify")
    public String verifyPayment(@RequestBody PaymentVerifyRequest request) {
        return paymentService.verifyPayment(request);
    }

    @GetMapping("/view")
    public List<Payment> viewAll() {
        return paymentService.viewAll();
    }

    @GetMapping("/get/{id}")
    public Payment getById(@PathVariable Integer id) {
        return paymentService.getById(id);
    }
}