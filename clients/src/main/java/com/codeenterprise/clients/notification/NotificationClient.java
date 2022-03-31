package com.codeenterprise.clients.notification;

import com.codeenterprise.configuration.dto.notification.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "notification",
        path = "api/v1/notification"
)
public interface NotificationClient {

    @PostMapping
    void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
