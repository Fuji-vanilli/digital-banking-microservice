package com.digitalbanking.accountservice.repository;

import com.digitalbanking.accountservice.entitie.OperationAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationAccountRepository extends MongoRepository<OperationAccount, String> {
    Optional<OperationAccount> findById(String id);
    boolean existsById(String id);
    void deleteById(String id);
    Page<OperationAccount> findAll(Pageable pageable);
}
