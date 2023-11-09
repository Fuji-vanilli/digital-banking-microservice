package com.digitalbanking.accountservice.validator;

import com.digitalbanking.accountservice.dto.BankAccountRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankAccountValidator {

    public static List<String> validate(BankAccountRequest request){
        List<String> errors= new ArrayList<>();

        if(Objects.isNull(request.getBalance())){
            errors.add("balance required!!!");
        }
        if(Objects.isNull(request.getAccountType())){
            errors.add("account type required!");
        }
        if(Objects.isNull(request.getCustomerCode())){
            errors.add("customer code required!");
        }
        if(Objects.isNull(request.getCurrency())){
            errors.add("currency code required!");
        }
        return errors;
    }
}
