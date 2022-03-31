package com.codeenterprise.clients.fraud;

import com.codeenterprise.configuration.dto.fraud.FraudsterCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraud")
public interface FraudClients {
    @GetMapping("api/v1/fraud-check/{customerId}")
    FraudsterCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);
}
