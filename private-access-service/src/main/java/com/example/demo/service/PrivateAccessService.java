package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PrivateAccessResponseDto;
import com.example.demo.entity.PrivateAccess;

public interface PrivateAccessService {

    PrivateAccessResponseDto inviteUser(PrivateAccess access);

    PrivateAccessResponseDto acceptInvitation(Integer accessId);

    PrivateAccessResponseDto rejectInvitation(Integer accessId);

    List<PrivateAccessResponseDto> viewAll();

    PrivateAccessResponseDto getById(Integer id);

    List<PrivateAccessResponseDto> getByUser(Integer userId);

    List<PrivateAccessResponseDto> getByEvent(Integer eventId);

    PrivateAccess getByEventAndUser(Integer eventId, Integer userId);
}