package com.viepovsky.clients.recommendation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "recommendation",
        path = "api/v1/recommendations"
)
public interface RecommendationClient {
    @GetMapping("{barberId}")
    RecommendationResponse isBarberRecommended(@PathVariable("barberId") Long barberId);
}
