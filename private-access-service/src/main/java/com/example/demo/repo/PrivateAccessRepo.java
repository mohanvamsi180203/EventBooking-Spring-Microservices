package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PrivateAccess;

public interface PrivateAccessRepo extends JpaRepository<PrivateAccess, Integer> {

    List<PrivateAccess> findByUserId(Integer userId);

    List<PrivateAccess> findByEventId(Integer eventId);

    PrivateAccess findByEventIdAndUserId(Integer eventId, Integer userId);
}