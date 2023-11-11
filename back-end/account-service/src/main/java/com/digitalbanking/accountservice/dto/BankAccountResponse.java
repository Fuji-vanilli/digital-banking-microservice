package com.digitalbanking.accountservice.dto;

import com.digitalbanking.accountservice.enumerationAccount.AccountType;
import com.digitalbanking.accountservice.model.Customer;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class BankAccountResponse {
    private String code;
    private BigDecimal balance;
    private Date createdAt;
    private Date updateBalance;
    private AccountType accountType;
    private Customer customer;
    private String currency;
    private String customerCode;
}
