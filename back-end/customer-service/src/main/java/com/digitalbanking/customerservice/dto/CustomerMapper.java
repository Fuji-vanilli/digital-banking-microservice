package com.digitalbanking.customerservice.dto;

import com.digitalbanking.customerservice.model.Customer;

public interface CustomerMapper {
    Customer mapToCustomer(CustomerRequest request);
    CustomerResponse mapToCustomerResponse(Customer customer);
}
