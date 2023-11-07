package com.digitalbanking.accountservice.model;

import com.digitalbanking.accountservice.model.enumerationAccount.OperationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
@Document(value = "accountOperation")
public class AccountOperation {
    @Id
    private String id;
    private Date operationDat;
    private BigDecimal amount;
    private OperationType type;
    private BankAccount bankAccount;
    private String description;
}
