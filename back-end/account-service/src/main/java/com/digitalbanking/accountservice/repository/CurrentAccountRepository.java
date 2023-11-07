package com.digitalbanking.accountservice.repository;

import com.digitalbanking.accountservice.model.BankAccount;
import com.digitalbanking.accountservice.model.CurrentAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CurrentAccountRepository extends MongoRepository<BankAccount, String> {
}
