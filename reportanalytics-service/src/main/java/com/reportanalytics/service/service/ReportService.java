package com.reportanalytics.service.service;

import java.util.List;

import com.reportanalytics.service.dto.CategoryReportDto;
import com.reportanalytics.service.dto.CityReportDto;
import com.reportanalytics.service.dto.SummaryResponseDto;

public interface ReportService {

    SummaryResponseDto getSummary();

    List<CategoryReportDto> getCategoryWise();

    List<CityReportDto> getCityWise();

    Double getTotalRevenue();

    Double getTotalRefunds();
}