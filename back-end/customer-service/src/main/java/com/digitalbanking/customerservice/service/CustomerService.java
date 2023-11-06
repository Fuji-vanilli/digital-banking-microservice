package com.digitalbanking.customerservice.service;

import com.digitalbanking.customerservice.Utils.Response;
import com.digitalbanking.customerservice.dto.CustomerRequest;

public interface CustomerService {
    Response add(CustomerRequest request);
    Response get(String code);
    Response all(int page, int size);
    Response delete(String code);
}
