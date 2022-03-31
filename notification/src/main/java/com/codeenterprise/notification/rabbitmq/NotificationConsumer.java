package com.codeenterprise.notification.rabbitmq;

import com.codeenterprise.configuration.dto.notification.NotificationRequest;
import com.codeenterprise.configuration.properties.NotificationMQProperties;
import com.codeenterprise.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class NotificationConsumer {

    @Autowired
    private final NotificationService notificationService;


    @RabbitListener(queues ="${rabbitmq.queue.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("Consumed {} from queue", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }
}
