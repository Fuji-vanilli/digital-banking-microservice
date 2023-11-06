package com.digitalbanking.customerservice.dto;

import com.digitalbanking.customerservice.model.Customer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerMapperImpl implements CustomerMapper{
    @Override
    public Customer mapToCustomer(CustomerRequest request) {
        return Customer.builder()
                .code(request.getCode())
                .name(request.getName())
                .email(request.getEmail())
                .build();
    }

    @Override
    public CustomerResponse mapToCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .code(customer.getCode())
                .name(customer.getName())
                .email(customer.getEmail())
                .createdDate(customer.getCreatedDate())
                .lastUpdateDate(customer.getLastUpdateDate())
                .build();
    }
}
