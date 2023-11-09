package com.digitalbanking.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
@Document(value = "customer")
public class Customer {
    @Id
    private String code;
    private String name;
    private String email;
    private Date createdDate;
    private Date lastUpdateDate;
}
