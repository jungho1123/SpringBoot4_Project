package com.inspirecamp7.myspringbootproject4.repository;

import com.inspirecamp7.myspringbootproject4.entity.Customer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {
    private CustomerRepository customerRepository;
    @Autowired
    public CustomerRepositoryTest(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Test
    @Disabled
    void testInsert(){
        // given 준비 단계
        Customer customer = new Customer();  // 컨트롤 알트 V 리턴타입 자동생성 단축키
        customer.setCustomerId("A003");
        customer.setCustomerName("박정호");

        // when 실행 단계
        Customer savedCustomer = customerRepository.save(customer);
        // then 검증 단계
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getCustomerId()).isEqualTo("A003");
        assertThat(savedCustomer.getCustomerName()).isEqualTo("박정호");
    }
    @Test
    @DisplayName(value = "Customer 조회 { 값이 일치하는 Customer 존재하는 경우 }")
    void testRead(){
        //given
        Optional<Customer> optionalCustomer = customerRepository.findByCustomerId("A003");
        // optional 이 담고 있는 customer가 값을 가지고 있으면 ?
        optionalCustomer.ifPresent(customer -> assertThat(customer.getCustomerId()).isEqualTo("A003"));
    }
    @Test
    @DisplayName(value = "Customer 조회 { 값이 일치하는 Customer 존재 하지 않는 경우 ")
    void testReadNotFound(){
        Customer optionalCustomer = customerRepository
                .findByCustomerId("A004")
                .orElseGet(Customer::new);
        assertThat(optionalCustomer.getCustomerId()).isNull();
    }



    @Test
    void findByCustomerId() {
    }

    @Test
    void findByCustomerNameContains() {
    }
}