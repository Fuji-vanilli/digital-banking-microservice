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

@Data
@AllArgsConstructor @NoArgsConstructor
@SuperBuilder
@Builder
@Document(value = "bankAccount")
public abstract class BankAccount {
    @Id
    private String id;
    private BigDecimal balance;
    private Date createdAt;
    private AccountStatus status;

}
