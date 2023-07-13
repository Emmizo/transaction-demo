package com.ecomerce.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce.springboot.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
} 
