package com.recommendation.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recommendation.service.dto.RecommendationResponseDto;
import com.recommendation.service.service.RecommendationService;

@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/getByUser/{userId}")
    public List<RecommendationResponseDto> getRecommendations(
            @PathVariable Integer userId) {

        return recommendationService.getRecommendations(userId);
    }
}