package com.inspirecamp7.myspringbootproject4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "customers")
public class Customer {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,unique = true)
    private String customerId;
    @Column(nullable = false)
    private String customerName;
    @Column(nullable = false,updatable = false) // updatable -> T 업데이트 가능한 컬럼 ->F 변경될수 없는 컬럼
    @CreationTimestamp
    LocalDateTime createdAt=LocalDateTime.now();

}
