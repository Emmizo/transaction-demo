package com.ecomerce.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce.springboot.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
    
}
