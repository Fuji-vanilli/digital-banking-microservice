package com.digitalbanking.accountservice.model;

import com.digitalbanking.accountservice.model.enumerationAccount.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

public abstract class BankAccount {
    protected String id;
    protected BigDecimal balance;
    protected Date createdAt;
    protected AccountStatus status;

    public BankAccount() {}

    public BankAccount(BigDecimal balance, AccountStatus status) {
        this.balance = balance;
        this.status = status;
    }
}
