package com.digitalbanking.accountservice.controller;

import com.digitalbanking.accountservice.Utils.Response;
import com.digitalbanking.accountservice.dto.CreditRequest;
import com.digitalbanking.accountservice.dto.DebitRequest;
import com.digitalbanking.accountservice.dto.TransferRequest;

import com.digitalbanking.accountservice.service.OperationAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.digitalbanking.accountservice.Utils.Root.APP_ROOT_OPERATION;

@RestController
@RequestMapping(APP_ROOT_OPERATION)
@RequiredArgsConstructor
public class OperationApi implements OperationController{
    private final OperationAccountService operationAccountService;
    @Override
    public ResponseEntity<Response> credit(CreditRequest request) {
        return ResponseEntity.ok(operationAccountService.credit(request));
    }

    @Override
    public ResponseEntity<Response> debit(DebitRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Response> transfer(TransferRequest request) {
        return null;
    }
}
