package com.digitalbanking.accountservice.repository;

import com.digitalbanking.accountservice.model.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankAccountRepository extends MongoRepository<BankAccount, String> {
}
