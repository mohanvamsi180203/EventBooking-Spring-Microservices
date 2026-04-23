package com.reportanalytics.service.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reportanalytics.service.client.BookingClient;
import com.reportanalytics.service.client.EventClient;
import com.reportanalytics.service.client.PaymentClient;
import com.reportanalytics.service.client.RefundClient;
import com.reportanalytics.service.client.UserClient;
import com.reportanalytics.service.dto.BookingDto;
import com.reportanalytics.service.dto.CategoryReportDto;
import com.reportanalytics.service.dto.CityReportDto;
import com.reportanalytics.service.dto.EventDto;
import com.reportanalytics.service.dto.PaymentDto;
import com.reportanalytics.service.dto.RefundDto;
import com.reportanalytics.service.dto.SummaryResponseDto;
import com.reportanalytics.service.dto.UserDto;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private EventClient eventClient;

    @Autowired
    private BookingClient bookingClient;

    @Autowired
    private PaymentClient paymentClient;

    @Autowired
    private RefundClient refundClient;

    @Override
    public SummaryResponseDto getSummary() {

        List<UserDto> users = userClient.viewAll();
        List<EventDto> events = eventClient.viewAll();
        List<BookingDto> bookings = bookingClient.viewAll();
        List<PaymentDto> payments = paymentClient.viewAll();
        List<RefundDto> refunds = refundClient.viewAll();

        SummaryResponseDto response = new SummaryResponseDto();

        response.setTotalUsers(users.size());
        response.setTotalEvents(events.size());
        response.setTotalBookings(bookings.size());

        Double revenue = payments.stream()
                .filter(p -> p.getPaymentStatus().equalsIgnoreCase("SUCCESS"))
                .mapToDouble(PaymentDto::getAmount)
                .sum();

        Double refundAmount = refunds.stream()
                .mapToDouble(RefundDto::getRefundAmount)
                .sum();

        Long cancelledCount = bookings.stream()
                .filter(b -> b.getBookingStatus().equalsIgnoreCase("CANCELLED"))
                .count();

        Long privateCount = events.stream()
                .filter(e -> e.getEventType().equalsIgnoreCase("PRIVATE"))
                .count();

        Long publicCount = events.stream()
                .filter(e -> e.getEventType().equalsIgnoreCase("PUBLIC"))
                .count();

        response.setTotalRevenue(revenue);
        response.setTotalRefunds(refundAmount);
        response.setCancelledBookings(cancelledCount.intValue());
        response.setPrivateEvents(privateCount.intValue());
        response.setPublicEvents(publicCount.intValue());

        return response;
    }

    @Override
    public List<CategoryReportDto> getCategoryWise() {

        List<EventDto> events = eventClient.viewAll();

        Map<String, Long> categoryMap = events.stream()
                .collect(Collectors.groupingBy(
                        EventDto::getCategory,
                        Collectors.counting()
                ));

        return categoryMap.entrySet()
                .stream()
                .map(entry -> new CategoryReportDto(
                        entry.getKey(),
                        entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CityReportDto> getCityWise() {

        List<EventDto> events = eventClient.viewAll();

        Map<String, Long> cityMap = events.stream()
                .collect(Collectors.groupingBy(
                        EventDto::getCity,
                        Collectors.counting()
                ));

        return cityMap.entrySet()
                .stream()
                .map(entry -> new CityReportDto(
                        entry.getKey(),
                        entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public Double getTotalRevenue() {

        return paymentClient.viewAll()
                .stream()
                .filter(p -> p.getPaymentStatus().equalsIgnoreCase("SUCCESS"))
                .mapToDouble(PaymentDto::getAmount)
                .sum();
    }

    @Override
    public Double getTotalRefunds() {

        return refundClient.viewAll()
                .stream()
                .mapToDouble(RefundDto::getRefundAmount)
                .sum();
    }
}