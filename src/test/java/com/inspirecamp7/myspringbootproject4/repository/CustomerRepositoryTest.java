package com.inspirecamp7.myspringbootproject4.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {
    private CustomerRepository customerRepository;
    @Autowired
    public CustomerRepositoryTest(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Test
    void testInsert(){
        //given 준비단계
        //when 실행 단계
        // then 검증 단계
    }




    @Test
    void findByCustomerId() {
    }

    @Test
    void findByCustomerNameContains() {
    }
}