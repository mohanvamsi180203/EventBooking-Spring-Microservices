package com.notification.service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notification.service.entity.Notification;

public interface NotificationRepo extends JpaRepository<Notification, Integer> {

    List<Notification> findByUserId(Integer userId);

    List<Notification> findByStatus(String status);
}