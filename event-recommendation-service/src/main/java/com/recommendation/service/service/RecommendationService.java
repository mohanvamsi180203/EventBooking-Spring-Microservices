package com.recommendation.service.service;

import java.util.List;

import com.recommendation.service.dto.RecommendationResponseDto;

public interface RecommendationService {

    List<RecommendationResponseDto> getRecommendations(Integer userId);
}