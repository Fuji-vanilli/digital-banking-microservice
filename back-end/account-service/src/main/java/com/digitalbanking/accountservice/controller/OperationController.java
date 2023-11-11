package com.digitalbanking.accountservice.controller;

import com.digitalbanking.accountservice.Utils.Response;
import com.digitalbanking.accountservice.dto.CreditRequest;
import com.digitalbanking.accountservice.dto.DebitRequest;
import com.digitalbanking.accountservice.dto.TransferRequest;
import com.digitalbanking.accountservice.entitie.OperationAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface OperationController {
    @PostMapping("credit")
    ResponseEntity<Response> credit(@RequestBody CreditRequest request);
    @PostMapping("debit")
    ResponseEntity<Response> debit(@RequestBody DebitRequest request);
    @PostMapping("transfer")
    ResponseEntity<Response> transfer(@RequestBody TransferRequest request);
}
