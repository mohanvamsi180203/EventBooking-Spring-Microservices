package com.seat.service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    private Integer eventId;

    @Column(name = "seat_row")
    private String rowNumber;

    @Column(name = "seat_column")
    private Integer columnNumber;

    private String seatLabel;

    private Double price;

    private String status;

    private Integer lockedBy;

    private LocalDateTime lockedUntil;
}