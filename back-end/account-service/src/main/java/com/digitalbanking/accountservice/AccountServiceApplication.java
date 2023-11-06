package com.digitalbanking.accountservice;

import com.digitalbanking.accountservice.model.BankAccount;
import com.digitalbanking.accountservice.model.CurrentAccount;
import com.digitalbanking.accountservice.model.SavingAccount;
import com.digitalbanking.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository repository) {
		return args -> {

		};
	}

}
