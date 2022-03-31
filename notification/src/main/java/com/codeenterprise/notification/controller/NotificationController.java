package com.codeenterprise.notification.controller;

import com.codeenterprise.configuration.dto.notification.NotificationRequest;
import com.codeenterprise.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("Fraud check request for customer {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }
}
