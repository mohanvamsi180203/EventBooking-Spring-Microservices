package com.event.service.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.service.entity.Event;

public interface EventRepo extends JpaRepository<Event, Integer> {

    List<Event> findByEventNameContaining(String eventName);

    List<Event> findByCategory(String category);

    List<Event> findByEventDate(LocalDate eventDate);

    List<Event> findByVenueId(Integer venueId);

    List<Event> findByOrganizerId(Integer organizerId);

    boolean existsByEventNameAndEventDateAndVenueId(
            String eventName,
            LocalDate eventDate,
            Integer venueId);

    List<Event> findByVenueIdAndEventDate(Integer venueId, LocalDate eventDate);
}