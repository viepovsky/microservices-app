package com.viepovsky.notification;

import com.viepovsky.clients.notification.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class NotificationService {
    private final NotificationRepository repository;

    NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public void storeNotification(NotificationRequest request) {
        repository.save(Notification.builder()
                .textMessage(request.textMessage())
                .whoSend(request.whoSend())
                .sendTime(LocalDateTime.now())
                .barberEmail(request.barberEmail())
                .barberId(request.barberId())
                .build());
        log.info("Saved request to database.");
    }
}
