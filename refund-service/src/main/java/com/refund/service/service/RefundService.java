package com.refund.service.service;

import java.util.List;

import com.refund.service.dto.RefundRequestDto;
import com.refund.service.dto.RefundResponseDto;

public interface RefundService {

    RefundResponseDto requestRefund(RefundRequestDto request);

    List<RefundResponseDto> viewAll();

    RefundResponseDto getById(Integer id);

    List<RefundResponseDto> getByUser(Integer userId);

    List<RefundResponseDto> getByStatus(String status);
}