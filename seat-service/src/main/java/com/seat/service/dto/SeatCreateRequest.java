package com.seat.service.dto;

import lombok.Data;

@Data
public class SeatCreateRequest {

    private Integer eventId;

    private Integer totalRows;

    private Integer totalColumns;

    private Double price;
}