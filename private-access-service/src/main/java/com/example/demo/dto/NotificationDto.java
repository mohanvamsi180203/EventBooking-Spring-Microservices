package com.example.demo.dto;

import lombok.Data;

@Data
public class NotificationDto {

    private Integer userId;
    private String notificationType;
    private String message;
}