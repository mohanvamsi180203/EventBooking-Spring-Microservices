package com.event.service.service;

import java.time.LocalDate;
import java.util.List;

import com.event.service.dto.EventResponseDto;
import com.event.service.entity.Event;

public interface EventService {

    Event addEvent(Event event);

    Event updateEvent(Integer id, Event event);

    String deleteEvent(Integer id);

    List<EventResponseDto> viewAll();

    EventResponseDto getById(Integer id);

    List<EventResponseDto> getByName(String name);

    List<EventResponseDto> getByCategory(String category);

    List<EventResponseDto> getByDate(LocalDate date);

    List<EventResponseDto> getByVenue(Integer venueId);

    List<EventResponseDto> getByOrganizer(Integer organizerId);
    
    Event reduceAvailableTickets(Integer id, Integer tickets);

    Event increaseAvailableTickets(Integer id, Integer tickets);

    Event getEventEntityById(Integer id);
}