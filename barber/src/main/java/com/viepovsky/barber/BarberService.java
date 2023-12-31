package com.viepovsky.barber;

import com.viepovsky.amqp.RabbitMQMessageProducer;
import com.viepovsky.clients.notification.NotificationClient;
import com.viepovsky.clients.notification.NotificationRequest;
import com.viepovsky.clients.recommendation.RecommendationClient;
import com.viepovsky.clients.recommendation.RecommendationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
record BarberService(
        BarberRepository repository,
        RecommendationClient recommendationClient,
        RabbitMQMessageProducer rabbitMQMessageProducer
) {
    void registerBarber(BarberRegistrationRequest request) {
        Barber barber = Barber.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .company(request.company())
                .email(request.email())
                .build();
        repository.saveAndFlush(barber);

        RecommendationResponse response = recommendationClient.isBarberRecommended(barber.getId());
        log.info("Response from Recommendation service:{}", response);
        if (response != null && response.isRecommended()) {
            log.info("Hurray, the barber you registered is recommended.");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                "Notification message",
                "viepovsky",
                barber.getEmail(),
                barber.getId()
        );
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}
