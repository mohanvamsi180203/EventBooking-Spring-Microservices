package com.notification.service.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NotificationResponseDto {

    private Integer notificationId;
    private String message;
    private String notificationType;
    private LocalDateTime createdAt;
    private String status;
    private String email;
    private String attachmentPath;
    
    private UserDto user;
}