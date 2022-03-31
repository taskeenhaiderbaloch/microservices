package com.codeenterprise.configuration.dto.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    private String message;
    private String sender;
    private LocalDateTime sentAt;
    private String toCustomerEmail;
    private Integer toCustomerId;
}
