package com.digitalbanking.accountservice.repository;

import com.digitalbanking.accountservice.model.SavingAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SavingAccountRepository extends MongoRepository<SavingAccount, String> {
}
