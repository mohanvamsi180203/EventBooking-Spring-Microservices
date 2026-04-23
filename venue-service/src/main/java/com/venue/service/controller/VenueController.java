package com.venue.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venue.service.entity.Venue;
import com.venue.service.service.VenueService;

@RestController
@RequestMapping("/api/venue")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @PostMapping("/save")
    public Venue addVenue(@RequestBody Venue venue) {
        return venueService.addVenue(venue);
    }

    @PutMapping("/update/{id}")
    public Venue updateVenue(@PathVariable Integer id, @RequestBody Venue venue) {
        return venueService.updateVenue(id, venue);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteVenue(@PathVariable Integer id) {
        return venueService.deleteVenue(id);
    }

    @GetMapping("/view")
    public List<Venue> viewAll() {
        return venueService.viewAll();
    }

    @GetMapping("/get/{id}")
    public Venue getById(@PathVariable Integer id) {
        return venueService.getById(id);
    }

    @GetMapping("/getByName/{name}")
    public List<Venue> getByName(@PathVariable String name) {
        return venueService.getByName(name);
    }

    @GetMapping("/getByLocation/{location}")
    public List<Venue> getByLocation(@PathVariable String location) {
        return venueService.getByLocation(location);
    }
}