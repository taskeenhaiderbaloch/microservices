package com.codeenterprise.customer.client;

import com.codeenterprise.dto.fraud.FraudsterCheckResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FraudClient {

    @Autowired
    private RestTemplate restTemplate;

    public FraudsterCheckResponse isFraudster(final Integer customerId){
        return restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}", FraudsterCheckResponse.class, customerId);
    }


}
