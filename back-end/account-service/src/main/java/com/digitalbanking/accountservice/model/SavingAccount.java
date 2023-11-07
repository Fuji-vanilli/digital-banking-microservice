package com.digitalbanking.accountservice.model;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Builder
@Document(value = "savingAccount")
public class SavingAccount extends BankAccount{
    private BigDecimal interestRate;
}
