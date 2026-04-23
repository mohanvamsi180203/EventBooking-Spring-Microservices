package com.organizer.dashboard.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organizer.dashboard.service.dto.OrganizerDashboardResponseDto;
import com.organizer.dashboard.service.service.OrganizerDashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class OrganizerDashboardController {

    @Autowired
    private OrganizerDashboardService organizerDashboardService;

    @GetMapping("/organizer/{organizerId}")
    public OrganizerDashboardResponseDto getDashboard(
            @PathVariable Integer organizerId) {

        return organizerDashboardService.getDashboard(organizerId);
    }
}