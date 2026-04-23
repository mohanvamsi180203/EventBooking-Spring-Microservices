package com.venue.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venue.service.entity.Venue;
import com.venue.service.repo.VenueRepo;

@Service
public class VenueServiceImpl implements VenueService {

    @Autowired
    private VenueRepo venueRepo;

    @Override
    public Venue addVenue(Venue venue) {

        if(venueRepo.existsByVenueNameAndLocation(
                venue.getVenueName(),
                venue.getLocation())) {

            throw new RuntimeException("Venue Already Exists In Same Location");
        }

        if(venue.getCapacity() <= 0) {
            throw new RuntimeException("Capacity Must Be Greater Than Zero");
        }

        return venueRepo.save(venue);
    }

    @Override
    public Venue updateVenue(Integer id, Venue venue) {

        Venue existingVenue = venueRepo.findById(id).orElse(null);

        if(existingVenue != null) {
            existingVenue.setVenueName(venue.getVenueName());
            existingVenue.setLocation(venue.getLocation());
            existingVenue.setCapacity(venue.getCapacity());
            existingVenue.setVenueType(venue.getVenueType());

            return venueRepo.save(existingVenue);
        }

        return null;
    }

    @Override
    public String deleteVenue(Integer id) {

        venueRepo.deleteById(id);

        return "Venue Deleted Successfully";
    }

    @Override
    public List<Venue> viewAll() {
        return venueRepo.findAll();
    }

    @Override
    public Venue getById(Integer id) {
        return venueRepo.findById(id).orElse(null);
    }

    @Override
    public List<Venue> getByName(String name) {
        return venueRepo.findByVenueNameContaining(name);
    }

    @Override
    public List<Venue> getByLocation(String location) {
        return venueRepo.findByLocation(location);
    }
}