package com.digitalbanking.customerservice.controller;

import com.digitalbanking.customerservice.Utils.Response;
import com.digitalbanking.customerservice.dto.CustomerRequest;
import jakarta.ws.rs.Path;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CustomerController {
    @PostMapping("add")
    ResponseEntity<Response> add(@RequestBody CustomerRequest request);
    @GetMapping("get/{code}")
    ResponseEntity<Response> get(@PathVariable String code);
    @GetMapping("all")
    ResponseEntity<Response> all(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    );
    @DeleteMapping("delete/{code}")
    ResponseEntity<Response> delete(@PathVariable String code);
}
