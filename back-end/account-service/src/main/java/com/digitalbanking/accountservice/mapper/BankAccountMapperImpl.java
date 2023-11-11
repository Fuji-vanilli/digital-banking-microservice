package com.digitalbanking.accountservice.mapper;

import com.digitalbanking.accountservice.dto.BankAccountRequest;
import com.digitalbanking.accountservice.dto.BankAccountResponse;
import com.digitalbanking.accountservice.entitie.BankAccount;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankAccountMapperImpl implements BankAccountMapper{
    @Override
    public BankAccount mapToBankAccount(BankAccountRequest request) {
        return BankAccount.builder()
                .customerCode(request.getCustomerCode())
                .accountType(request.getAccountType())
                .balance(request.getBalance())
                .currency(request.getCurrency())
                .build();
    }

    @Override
    public BankAccountResponse mapToBankAccountResponse(BankAccount bankAccount) {
        return BankAccountResponse.builder()
                .code(bankAccount.getCode())
                .accountType(bankAccount.getAccountType())
                .balance(bankAccount.getBalance())
                .currency(bankAccount.getCurrency())
                .createdAt(bankAccount.getCreatedAt())
                .updateBalance(bankAccount.getUpdateBalance())
                .customer(bankAccount.getCustomer())
                .customerCode(bankAccount.getCustomerCode())
                .build();
    }
}
