package com.codeenterprise.fraud.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NotificationClient {

    @Autowired
    private RestTemplate restTemplate;


}
