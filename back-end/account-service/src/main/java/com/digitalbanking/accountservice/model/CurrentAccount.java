package com.digitalbanking.accountservice.model;

import com.digitalbanking.accountservice.model.enumerationAccount.AccountStatus;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

//@Data
//@Builder
@Document(value = "currentAccount")
public class CurrentAccount extends BankAccount{
    private BigDecimal overDraft;

    public CurrentAccount() {}
    public CurrentAccount(BigDecimal balance, AccountStatus status, BigDecimal overDraft) {
        super(balance, status);
        this.overDraft= overDraft;
    }
}
