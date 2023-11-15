package com.viepovsky.recommendation;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/recommendations")
class RecommendationController {
    private final RecommendationService service;

    RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @GetMapping("/{barberId}")
    RecommendationCheckResponse isBarberRecommended(@PathVariable Long barberId) {
        boolean isRecommended = service.isBarberRecommended(barberId);
        return new RecommendationCheckResponse(isRecommended);
    }
}
