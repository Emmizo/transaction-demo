package com.ecomerce.springboot.dto;

import com.ecomerce.springboot.entity.Order;
import com.ecomerce.springboot.entity.Payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
