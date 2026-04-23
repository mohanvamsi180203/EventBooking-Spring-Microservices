package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PrivateAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accessId;

    private Integer eventId;
    private Integer userId;
    private String invitationStatus;
}