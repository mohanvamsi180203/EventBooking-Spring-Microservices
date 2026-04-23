package com.refund.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refund.service.dto.RefundRequestDto;
import com.refund.service.dto.RefundResponseDto;
import com.refund.service.service.RefundService;

@RestController
@RequestMapping("/api/refund")
public class RefundController {

    @Autowired
    private RefundService refundService;

    @PostMapping("/request")
    public RefundResponseDto requestRefund(
            @RequestBody RefundRequestDto request) {

        return refundService.requestRefund(request);
    }

    @GetMapping("/view")
    public List<RefundResponseDto> viewAll() {
        return refundService.viewAll();
    }

    @GetMapping("/get/{id}")
    public RefundResponseDto getById(@PathVariable Integer id) {
        return refundService.getById(id);
    }

    @GetMapping("/getByUser/{userId}")
    public List<RefundResponseDto> getByUser(@PathVariable Integer userId) {
        return refundService.getByUser(userId);
    }

    @GetMapping("/getByStatus/{status}")
    public List<RefundResponseDto> getByStatus(@PathVariable String status) {
        return refundService.getByStatus(status);
    }
}