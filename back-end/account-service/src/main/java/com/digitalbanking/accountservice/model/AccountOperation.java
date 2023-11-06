package com.digitalbanking.accountservice.model;

import com.digitalbanking.accountservice.model.enumerationAccount.OperationType;

import java.math.BigDecimal;
import java.util.Date;

public class AccountOperation {
    private String id;
    private Date operationDate;
    private BigDecimal amount;
    private OperationType type;
    private BankAccount bankAccount;
    private String description;
}
