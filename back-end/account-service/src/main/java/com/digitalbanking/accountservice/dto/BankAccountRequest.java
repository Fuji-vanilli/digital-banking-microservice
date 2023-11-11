package com.digitalbanking.accountservice.dto;

import com.digitalbanking.accountservice.enumerationAccount.AccountType;
import lombok.*;

import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class BankAccountRequest {
    private BigDecimal balance;
    private AccountType accountType;
    private String currency;
    private String customerCode;
}
