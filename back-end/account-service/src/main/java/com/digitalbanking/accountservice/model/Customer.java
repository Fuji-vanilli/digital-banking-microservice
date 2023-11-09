package com.digitalbanking.accountservice.model;

import lombok.*;

import java.util.Date;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Customer {
    private String code;
    private String name;
    private String email;
    private Date createdDate;
    private Date lastUpdateDate;
}
