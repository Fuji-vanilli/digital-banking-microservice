package com.digitalbanking.accountservice.service;

import com.digitalbanking.accountservice.Utils.Response;
import com.digitalbanking.accountservice.dto.BankAccountRequest;

public interface BankAccountService {
    Response add(BankAccountRequest request);
    Response get(String code);
    Response all(int page, int size);
    Response delete(String code);
}
