package com.search.service.service;

import java.time.LocalDate;
import java.util.List;

import com.search.service.dto.SearchResponseDto;

public interface SearchService {

    List<SearchResponseDto> searchByName(String name);

    List<SearchResponseDto> searchByCategory(String category);

    List<SearchResponseDto> searchByCity(String city);

    List<SearchResponseDto> searchByDate(LocalDate date);

    List<SearchResponseDto> searchByPrice(Double min, Double max);

    List<SearchResponseDto> searchByStatus(String status);

    List<SearchResponseDto> searchByType(String eventType);
}