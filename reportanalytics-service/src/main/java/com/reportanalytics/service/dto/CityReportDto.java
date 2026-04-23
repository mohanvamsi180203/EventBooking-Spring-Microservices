package com.reportanalytics.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityReportDto {

    private String city;
    private Long count;
}