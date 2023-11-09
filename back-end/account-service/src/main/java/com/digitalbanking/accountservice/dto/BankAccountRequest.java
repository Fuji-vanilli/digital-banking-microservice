package com.digitalbanking.accountservice.dto;

import com.digitalbanking.accountservice.entitie.enumerationAccount.AccountType;
import com.digitalbanking.accountservice.model.Customer;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class BankAccountRequest {
    private BigDecimal balance;
    private AccountType accountType;
    private String currency;
    private String customerCode;
}
