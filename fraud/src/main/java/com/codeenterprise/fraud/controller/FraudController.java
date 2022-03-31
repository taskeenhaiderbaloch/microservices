package com.codeenterprise.fraud.controller;

import com.codeenterprise.dto.fraud.FraudsterCheckResponse;
import com.codeenterprise.fraud.service.FraudCheckHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    @Autowired
    private FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping("/{customerId}")
    FraudsterCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        log.info("Fraud check request for customer {}", customerId);
        Boolean isFraudulentCustomer = fraudCheckHistoryService.isfraudulentCustomer(customerId);
        return FraudsterCheckResponse.builder()
                .isFraudster(isFraudulentCustomer).build();
    }
}
