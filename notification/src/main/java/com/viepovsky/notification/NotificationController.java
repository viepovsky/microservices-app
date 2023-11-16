package com.viepovsky.notification;

import com.viepovsky.clients.notification.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/notifications")
class NotificationController {
    private final NotificationService notificationService;

    NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping()
    void storeNotification(@RequestBody NotificationRequest request) {
        log.info("New request to store notification:{}", request);
        notificationService.storeNotification(request);
    }
}
