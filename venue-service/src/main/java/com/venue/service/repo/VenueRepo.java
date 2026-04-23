package com.venue.service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venue.service.entity.Venue;

public interface VenueRepo extends JpaRepository<Venue, Integer> {

    List<Venue> findByVenueNameContaining(String venueName);

    List<Venue> findByLocation(String location);

    boolean existsByVenueNameAndLocation(String venueName, String location);
}