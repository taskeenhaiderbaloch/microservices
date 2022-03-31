package com.codeenterprise.customer.service;


import com.codeenterprise.clients.fraud.FraudClients;
import com.codeenterprise.clients.notification.NotificationClient;
import com.codeenterprise.customer.entity.Customer;
import com.codeenterprise.dto.customer.CustomerRequest;
import com.codeenterprise.customer.repository.CustomerRepository;
import com.codeenterprise.dto.fraud.FraudsterCheckResponse;
import com.codeenterprise.dto.notification.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FraudClients fraudClient;

    @Autowired
    private NotificationClient notificationClient;

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

        NotificationRequest notificationRequest= NotificationRequest.builder()
                .toCustomerId(customer.getId())
                .toCustomerEmail(customer.getEmail())
                .message(String.format("Hi %s, Welcome to code enterprise... ", customer.getFirstName()))
                .sender(customer.getFirstName())
                .build();

        notificationClient.sendNotification(notificationRequest);
    }
}
