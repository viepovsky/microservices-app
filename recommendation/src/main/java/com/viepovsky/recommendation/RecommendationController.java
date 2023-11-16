package com.viepovsky.recommendation;

import com.viepovsky.clients.recommendation.RecommendationResponse;
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
    RecommendationResponse isBarberRecommended(@PathVariable Long barberId) {
        log.info("New recommendation check for barber {}", barberId);
        boolean isRecommended = service.isBarberRecommended(barberId);
        return new RecommendationResponse(isRecommended);
    }
}
