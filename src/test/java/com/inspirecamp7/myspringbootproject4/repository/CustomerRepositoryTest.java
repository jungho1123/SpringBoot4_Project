package com.inspirecamp7.myspringbootproject4.repository;

import com.inspirecamp7.myspringbootproject4.entity.Customer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    @Rollback(false) // 등록되 데이터를 반드시 확인하고 싶으니 rollback 처리를 하지 마
    void testInsert(){
        // given 준비 단계
        Customer customer = new Customer();  // 컨트롤 알트 V 리턴타입 자동생성 단축키
        customer.setCustomerId("A004");
        customer.setCustomerName("박정호");

        // when 실행 단계
        Customer savedCustomer = customerRepository.save(customer);
        // then 검증 단계
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getCustomerId()).isEqualTo("A004");
        assertThat(savedCustomer.getCustomerName()).isEqualTo("박정호");
    }
    @Test
    @DisplayName(value = "Customer 조회 { 값이 일치하는 Customer 존재하는 경우 }")
    @Transactional(readOnly = true)
    void testRead(){
        //given
        Optional<Customer> optionalCustomer = customerRepository.findByCustomerId("A003");
        // optional 이 담고 있는 customer가 값을 가지고 있으면 ?
        optionalCustomer.ifPresent(customer -> assertThat(customer.getCustomerId()).isEqualTo("A003"));
    }
    @Test
    @DisplayName(value = "Customer 조회 { 값이 일치하는 Customer 존재 하지 않는 경우 ")
    void testReadNotFound(){
//        Customer optionalCustomer = customerRepository
//                .findByCustomerId("A004")
//                .orElseGet(Customer::new);
//        assertThat(optionalCustomer.getCustomerId()).isNull();

        Customer existCustomer=customerRepository
                .findByCustomerId("A003")
                .orElseGet(Customer::new);
        assertThat(existCustomer.getCustomerId()).isNotNull();

        Customer notExistCustomer=customerRepository
                .findByCustomerId("A006")
                .orElseGet(Customer::new);
        assertThat(notExistCustomer.getCustomerId()).isNull();
    }
    @Test
    @DisplayName("")
    @Disabled
    void testReadNotFoundException(){
        //orElseThrow 함수형 인터페이스supplier 추상메서드 T
        Customer existCustomer=customerRepository
                .findByCustomerId("A003")
                .orElseThrow(()-> new RuntimeException("CUSTOMER NOT FOUND"));
        assertThat(existCustomer.getCustomerId()).isNotNull();

        Customer notExistCustomer = customerRepository
                .findByCustomerId("A006")
                .orElseThrow(() -> new RuntimeException("CUSTOMER NOT FOUND"));
        assertThat(notExistCustomer.getCustomerId()).isNull();
    }
    @Test
    @Transactional
    @DisplayName("업데이트 테스트")
    void testUpdate(){

    }



    @Test
    void findByCustomerId() {
    }

    @Test
    void findByCustomerNameContains() {
    }
}