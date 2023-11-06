package com.digitalbanking.customerservice.repository;

import com.digitalbanking.customerservice.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByCode(String code);
    boolean existsByCode(String code);
    Page<Customer> findAll(Pageable pageable);
    void deleteByCode(String code);
}
