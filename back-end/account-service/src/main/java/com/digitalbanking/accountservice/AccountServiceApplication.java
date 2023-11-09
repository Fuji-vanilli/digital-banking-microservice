package com.digitalbanking.accountservice;

import com.digitalbanking.accountservice.entitie.BankAccount;
import com.digitalbanking.accountservice.entitie.enumerationAccount.AccountType;
import com.digitalbanking.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository repository) {
		return args -> {
			List<BankAccount> bankAccounts= List.of(
					BankAccount.builder()
							.accountType(AccountType.CURRENT_ACCOUNT)
							.balance(new BigDecimal(5000))
							.createdAt(new Date())
							.code("Dollar")
							.build(),
					BankAccount.builder()
							.accountType(AccountType.CURRENT_ACCOUNT)
							.balance(new BigDecimal(7000))
							.createdAt(new Date())
							.code("Euro")
							.build()
			);
			repository.saveAll(bankAccounts);
		};
	}

}
