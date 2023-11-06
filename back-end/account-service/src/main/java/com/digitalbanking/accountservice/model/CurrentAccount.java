package com.digitalbanking.accountservice.model;

import com.digitalbanking.accountservice.model.enumerationAccount.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Document(value = "currentAccount")
public class CurrentAccount extends BankAccount{
    private BigDecimal overDraft;
}
