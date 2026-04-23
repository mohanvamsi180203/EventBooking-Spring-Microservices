package com.reportanalytics.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reportanalytics.service.dto.CategoryReportDto;
import com.reportanalytics.service.dto.CityReportDto;
import com.reportanalytics.service.dto.SummaryResponseDto;
import com.reportanalytics.service.service.ReportService;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/summary")
    public SummaryResponseDto getSummary() {
        return reportService.getSummary();
    }

    @GetMapping("/categoryWise")
    public List<CategoryReportDto> getCategoryWise() {
        return reportService.getCategoryWise();
    }

    @GetMapping("/cityWise")
    public List<CityReportDto> getCityWise() {
        return reportService.getCityWise();
    }

    @GetMapping("/revenue")
    public Double getRevenue() {
        return reportService.getTotalRevenue();
    }

    @GetMapping("/refunds")
    public Double getRefunds() {
        return reportService.getTotalRefunds();
    }
}