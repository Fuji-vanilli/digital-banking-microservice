package com.digitalbanking.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "savingAccount")
public class SavingAccount extends BankAccount{
    private BigDecimal interestRate;
}
