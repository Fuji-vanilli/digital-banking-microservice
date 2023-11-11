package com.digitalbanking.accountservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class TransferRequest {
    private String accountCodeResource;
    private String accountCodeDestination;
    private BigDecimal amount;
    private String description;
}
