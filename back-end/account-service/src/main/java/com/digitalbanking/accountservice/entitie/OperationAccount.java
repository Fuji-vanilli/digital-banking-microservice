package com.digitalbanking.accountservice.entitie;

import com.digitalbanking.accountservice.enumerationAccount.OperationType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Document(value = "operationAccount")
public class OperationAccount {
    private String id;
    private Date operationDate;
    private OperationType type;
    private BankAccount bankAccount;
    private String description;
}
