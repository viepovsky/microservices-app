package com.viepovsky.notification.rabbitmq;

import com.viepovsky.clients.notification.NotificationRequest;
import com.viepovsky.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationConsumer {
    private final NotificationService service;

    public NotificationConsumer(NotificationService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest request) {
        log.info("Consumed {} from rabbitmq queue", request);
        service.storeNotification(request);
    }
}
