package com.digitalbanking.accountservice.controller;

import com.digitalbanking.accountservice.Utils.Response;
import com.digitalbanking.accountservice.dto.BankAccountRequest;
import com.digitalbanking.accountservice.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.digitalbanking.accountservice.Utils.Root.APP_ROOT_BANK_ACCOUNT;

@RestController
@RequestMapping(APP_ROOT_BANK_ACCOUNT)
@RequiredArgsConstructor
public class BankAccountApi implements BankAccountController{
    private final BankAccountService bankAccountService;
    @Override
    public ResponseEntity<Response> add(BankAccountRequest request) {
        return ResponseEntity.ok(bankAccountService.add(request));
    }

    @Override
    public ResponseEntity<Response> get(String code) {
        return ResponseEntity.ok(bankAccountService.get(code));
    }

    @Override
    public ResponseEntity<Response> all(int page, int size) {
        return ResponseEntity.ok(bankAccountService.all(page, size));
    }

    @Override
    public ResponseEntity<Response> delete(String code) {
        return ResponseEntity.ok(bankAccountService.delete(code));
    }
}
