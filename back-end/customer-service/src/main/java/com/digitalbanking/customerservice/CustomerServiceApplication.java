package com.digitalbanking.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@RefreshScope
@CrossOrigin(origins = "*")
public class CustomerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}
