package com.viepovsky.barber;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
record BarberService(BarberRepository repository, RestTemplate restTemplate) {
    void registerBarber(BarberRegistrationRequest request) {
        Barber barber = Barber.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .company(request.company())
                .email(request.email())
                .build();
        repository.saveAndFlush(barber);

        RecommendationResponse response = restTemplate.getForObject(
                "http://RECOMMENDATION/api/v1/recommendations/{barberId}",
                RecommendationResponse.class,
                barber.getId()
        );
        log.info("Response from Recommendation service:{}", response);
        if (response != null && response.isRecommended()) {
            log.info("Hurray, the barber you registered is recommended.");
        }
    }
}
