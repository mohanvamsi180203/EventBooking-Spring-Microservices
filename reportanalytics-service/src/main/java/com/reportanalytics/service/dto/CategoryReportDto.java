package com.reportanalytics.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryReportDto {

    private String category;
    private Long count;
}