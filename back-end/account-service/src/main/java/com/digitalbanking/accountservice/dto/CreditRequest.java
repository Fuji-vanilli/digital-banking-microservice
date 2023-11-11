package com.digitalbanking.accountservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class CreditRequest {
    private String accountCode;
    private BigDecimal amount;
    private String description;
}
