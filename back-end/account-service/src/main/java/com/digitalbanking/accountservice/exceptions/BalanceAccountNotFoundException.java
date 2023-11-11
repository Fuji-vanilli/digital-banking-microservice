package com.digitalbanking.accountservice.exceptions;

public class BalanceAccountNotFoundException extends RuntimeException {

    public BalanceAccountNotFoundException(String message) {
        super(message);
    }
    public BalanceAccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
