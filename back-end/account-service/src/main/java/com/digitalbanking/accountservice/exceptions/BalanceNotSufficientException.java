package com.digitalbanking.accountservice.exceptions;

public class BalanceNotSufficientException extends RuntimeException{

    public BalanceNotSufficientException(String message) {
        super(message);
    }
    public BalanceNotSufficientException(String message, Throwable cause) {
        super(message, cause);
    }
}
