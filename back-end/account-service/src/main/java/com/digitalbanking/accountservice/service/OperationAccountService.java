package com.digitalbanking.accountservice.service;

import com.digitalbanking.accountservice.Utils.Response;
import com.digitalbanking.accountservice.dto.CreditRequest;
import com.digitalbanking.accountservice.dto.DebitRequest;
import com.digitalbanking.accountservice.dto.TransferRequest;

import java.math.BigDecimal;

public interface OperationAccountService {
    Response credit(CreditRequest request);
    Response debit(DebitRequest request);
    Response transfer(TransferRequest request);
}
