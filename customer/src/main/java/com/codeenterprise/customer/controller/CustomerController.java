package com.codeenterprise.customer.controller;


import com.codeenterprise.configuration.dto.customer.CustomerRequest;
import com.codeenterprise.customer.service.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping
    public void create(@RequestBody CustomerRequest request){
        log.info("New Customer registration request {}", request);
        try {
            customerService.registerCustomer(request);
        } catch (IllegalAccessException ie){
            log.info("Fraudster Customer " + ie);
        } catch (Exception e){
            log.info("Registration Customer Exception " + e);
        }
    }
}
