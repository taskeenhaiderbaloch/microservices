package com.codeenterprise.customer.service;

import com.codeenterprise.customer.client.FraudClient;
import com.codeenterprise.customer.entity.Customer;
import com.codeenterprise.dto.customer.CustomerRequest;
import com.codeenterprise.customer.repository.CustomerRepository;
import com.codeenterprise.dto.fraud.FraudsterCheckResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FraudClient fraudClient;

    public void registerCustomer(CustomerRequest request) throws IllegalAccessException {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        customer = customerRepository.save(customer);

        FraudsterCheckResponse response = fraudClient.isFraudster(customer.getId());

        if (response.getIsFraudster()){
            throw new IllegalAccessException("Fraudster Customer");
        }
    }
}
