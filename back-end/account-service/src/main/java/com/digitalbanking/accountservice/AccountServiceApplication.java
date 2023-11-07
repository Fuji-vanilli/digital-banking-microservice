package com.digitalbanking.accountservice;

import com.digitalbanking.accountservice.model.CurrentAccount;
import com.digitalbanking.accountservice.model.enumerationAccount.AccountStatus;
import com.digitalbanking.accountservice.repository.CurrentAccountRepository;
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
	CommandLineRunner commandLineRunner(CurrentAccountRepository repository) {
		return args -> {
			repository.save(new CurrentAccount(new BigDecimal(12), AccountStatus.CREATED, new BigDecimal(4)));
		};
	}

}
