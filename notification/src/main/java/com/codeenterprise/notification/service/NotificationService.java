package com.codeenterprise.notification.service;

import com.codeenterprise.dto.notification.NotificationRequest;
import com.codeenterprise.notification.entity.Notification;
import com.codeenterprise.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public void sendNotification(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .message(notificationRequest.getMessage())
                .sender(notificationRequest.getSender())
                .sentAt(LocalDateTime.now())
                .toCustomerEmail(notificationRequest.getToCustomerEmail())
                .toCustomerId(notificationRequest.getToCustomerId())
                .build();

        notificationRepository.save(notification);
    }
}
