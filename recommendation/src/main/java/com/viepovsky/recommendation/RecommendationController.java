package com.viepovsky.recommendation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
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
        log.info("New recommendation check for barber {}", barberId);
        return new RecommendationCheckResponse(isRecommended);
    }
}
