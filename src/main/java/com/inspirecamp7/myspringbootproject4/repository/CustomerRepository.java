package com.inspirecamp7.myspringbootproject4.repository;

import com.inspirecamp7.myspringbootproject4.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCustomerId(String customerId);
    //Optional<Customer> findbyCustomerId(String customerId); 진짜 규칙 엄청 엄격하다
}
