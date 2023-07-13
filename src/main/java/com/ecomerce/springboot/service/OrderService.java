package com.ecomerce.springboot.service;

import com.ecomerce.springboot.dto.OrderRequest;
import com.ecomerce.springboot.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
