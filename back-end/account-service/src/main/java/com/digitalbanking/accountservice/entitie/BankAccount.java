package com.digitalbanking.accountservice.entitie;

import com.digitalbanking.accountservice.entitie.enumerationAccount.AccountType;
import com.digitalbanking.accountservice.model.Customer;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Document(value = "bankAccount")
@Builder
public class BankAccount {
    @Id
    private String code;
    private BigDecimal balance;
    private Date createdAt;
    private AccountType accountType;
    private Customer customer;
    private String currency;
    private String customerCode;
}
