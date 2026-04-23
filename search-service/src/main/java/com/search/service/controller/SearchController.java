package com.search.service.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.search.service.dto.SearchResponseDto;
import com.search.service.service.SearchService;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/byName/{name}")
    public List<SearchResponseDto> searchByName(@PathVariable String name) {
        return searchService.searchByName(name);
    }

    @GetMapping("/byCategory/{category}")
    public List<SearchResponseDto> searchByCategory(@PathVariable String category) {
        return searchService.searchByCategory(category);
    }

    @GetMapping("/byCity/{city}")
    public List<SearchResponseDto> searchByCity(@PathVariable String city) {
        return searchService.searchByCity(city);
    }

    @GetMapping("/byDate/{date}")
    public List<SearchResponseDto> searchByDate(@PathVariable LocalDate date) {
        return searchService.searchByDate(date);
    }

    @GetMapping("/byPrice/{min}/{max}")
    public List<SearchResponseDto> searchByPrice(
            @PathVariable Double min,
            @PathVariable Double max) {

        return searchService.searchByPrice(min, max);
    }

    @GetMapping("/byStatus/{status}")
    public List<SearchResponseDto> searchByStatus(@PathVariable String status) {
        return searchService.searchByStatus(status);
    }

    @GetMapping("/byType/{eventType}")
    public List<SearchResponseDto> searchByType(@PathVariable String eventType) {
        return searchService.searchByType(eventType);
    }
}