package com.digitalbanking.accountservice.mapper;

import com.digitalbanking.accountservice.dto.BankAccountRequest;
import com.digitalbanking.accountservice.dto.BankAccountResponse;
import com.digitalbanking.accountservice.entitie.BankAccount;

public interface BankAccountMapper {
    BankAccount mapToBankAccount(BankAccountRequest request);
    BankAccountResponse mapToBankAccountResponse(BankAccount bankAccount);
}
