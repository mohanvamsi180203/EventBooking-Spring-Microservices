package com.organizer.dashboard.service.service;

import com.organizer.dashboard.service.dto.OrganizerDashboardResponseDto;

public interface OrganizerDashboardService {

    OrganizerDashboardResponseDto getDashboard(Integer organizerId);
}