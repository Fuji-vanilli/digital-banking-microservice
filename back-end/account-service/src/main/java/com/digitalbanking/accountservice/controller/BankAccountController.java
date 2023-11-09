package com.digitalbanking.accountservice.controller;

import com.digitalbanking.accountservice.Utils.Response;
import com.digitalbanking.accountservice.dto.BankAccountRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface BankAccountController {
    @PostMapping("add")
    ResponseEntity<Response> add(@RequestBody BankAccountRequest request);
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
