package com.notification.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notification.service.dto.NotificationResponseDto;
import com.notification.service.entity.Notification;
import com.notification.service.service.NotificationService;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send")
    public NotificationResponseDto sendNotification(@RequestBody Notification notification) {
        return notificationService.sendNotification(notification);
    }

    @GetMapping("/view")
    public List<NotificationResponseDto> viewAll() {
        return notificationService.viewAll();
    }

    @GetMapping("/get/{id}")
    public NotificationResponseDto getById(@PathVariable Integer id) {
        return notificationService.getById(id);
    }

    @GetMapping("/getByUser/{userId}")
    public List<NotificationResponseDto> getByUser(@PathVariable Integer userId) {
        return notificationService.getByUser(userId);
    }

    @GetMapping("/getByStatus/{status}")
    public List<NotificationResponseDto> getByStatus(@PathVariable String status) {
        return notificationService.getByStatus(status);
    }

    @PutMapping("/markAsRead/{id}")
    public NotificationResponseDto markAsRead(@PathVariable Integer id) {
        return notificationService.markAsRead(id);
    }
}