package com.organizer.dashboard.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organizer.dashboard.service.client.BookingClient;
import com.organizer.dashboard.service.client.EventClient;
import com.organizer.dashboard.service.client.UserClient;
import com.organizer.dashboard.service.dto.BookingDto;
import com.organizer.dashboard.service.dto.EventDto;
import com.organizer.dashboard.service.dto.OrganizerDashboardResponseDto;
import com.organizer.dashboard.service.dto.UserDto;

@Service
public class OrganizerDashboardServiceImpl implements OrganizerDashboardService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private EventClient eventClient;

    @Autowired
    private BookingClient bookingClient;

    @Override
    public OrganizerDashboardResponseDto getDashboard(Integer organizerId) {

        UserDto organizer = userClient.getUserEntityById(organizerId);

        if(organizer == null) {
            throw new RuntimeException("Organizer Not Found");
        }

        List<EventDto> events = eventClient.getByOrganizer(organizerId);

        List<BookingDto> bookings = bookingClient.viewAll();

        int totalEvents = events.size();
        int totalBookings = 0;
        int totalTicketsSold = 0;
        double totalRevenue = 0;
        int upcomingEvents = 0;
        int cancelledEvents = 0;

        for(EventDto event : events) {

            if(event.getStatus().equals("UPCOMING")) {
                upcomingEvents++;
            }

            if(event.getStatus().equals("CANCELLED")) {
                cancelledEvents++;
            }

            for(BookingDto booking : bookings) {

                if(booking.getEvent() != null &&
                   booking.getEvent().getEventId().equals(event.getEventId()) &&
                   booking.getBookingStatus().equals("BOOKED")) {

                    totalBookings++;
                    totalTicketsSold += booking.getQuantity();
                    totalRevenue += booking.getTotalAmount();
                }
            }
        }

        OrganizerDashboardResponseDto response = new OrganizerDashboardResponseDto();

        response.setOrganizerId(organizer.getUserId());
        response.setOrganizerName(organizer.getName());
        response.setTotalEvents(totalEvents);
        response.setTotalBookings(totalBookings);
        response.setTotalTicketsSold(totalTicketsSold);
        response.setTotalRevenue(totalRevenue);
        response.setUpcomingEvents(upcomingEvents);
        response.setCancelledEvents(cancelledEvents);

        return response;
    }
}