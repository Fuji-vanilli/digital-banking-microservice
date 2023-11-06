package com.digitalbanking.customerservice.validator;


import com.digitalbanking.customerservice.dto.CustomerRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerValidator {

    public static List<String> validate(CustomerRequest request){
        List<String> errors= new ArrayList<>();

        if(Objects.isNull(request.getCode())){
            errors.add("code required!!!");
        }
        if(Objects.isNull(request.getName())){
            errors.add("name required!");
        }
        if(Objects.isNull(request.getEmail())){
            errors.add("email required!");
        }
        return errors;
    }
}
