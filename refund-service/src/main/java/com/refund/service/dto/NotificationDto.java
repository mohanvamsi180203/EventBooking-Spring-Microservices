package com.refund.service.dto;

import lombok.Data;

@Data
public class NotificationDto {

    private Integer userId;
    private String message;
    private String notificationType;
}