package com.viepovsky.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "notification",
        path = "api/v1/notifications",
        url = "${feign.client.notification.url}"
)
public interface NotificationClient {
    @PostMapping
    void storeNotification(@RequestBody NotificationRequest request);
}
