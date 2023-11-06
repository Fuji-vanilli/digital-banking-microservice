package com.digitalbanking.customerservice.controller;

import com.digitalbanking.customerservice.Utils.Response;
import com.digitalbanking.customerservice.dto.CustomerRequest;
import com.digitalbanking.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.digitalbanking.customerservice.Utils.Root.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT)
@RequiredArgsConstructor
public class CustomerApi implements CustomerController{
    private final CustomerService customerService;
    @Override
    public ResponseEntity<Response> add(CustomerRequest request) {
        return ResponseEntity.ok(customerService.add(request));
    }

    @Override
    public ResponseEntity<Response> get(String code) {
        return ResponseEntity.ok(customerService.get(code));
    }

    @Override
    public ResponseEntity<Response> all(int page, int size) {
        return ResponseEntity.ok(customerService.all(page, size));
    }

    @Override
    public ResponseEntity<Response> delete(String code) {
        return ResponseEntity.ok(customerService.delete(code));
    }
}
