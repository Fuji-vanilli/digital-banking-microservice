package com.digitalbanking.accountservice.repository;

import com.digitalbanking.accountservice.entitie.BankAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends MongoRepository<BankAccount, String> {
    Optional<BankAccount> findByCode(String code);
    boolean existsByCode(String code);
    Page<BankAccount> findAll(Pageable pageable);
    void deleteByCode(String code);
}
