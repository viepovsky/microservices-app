package com.viepovsky.recommendation;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
class RecommendationService {
    private final RecommendationRepository repository;

    RecommendationService(RecommendationRepository repository) {
        this.repository = repository;
    }

    boolean isBarberRecommended(Long barberId) {
        repository.save(
                Recommendation.builder()
                        .barberId(barberId)
                        .isRecommended(false)
                        .recommendationCheckTime(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
