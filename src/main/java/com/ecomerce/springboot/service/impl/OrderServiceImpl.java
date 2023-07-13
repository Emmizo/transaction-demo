package com.ecomerce.springboot.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomerce.springboot.dto.OrderRequest;
import com.ecomerce.springboot.dto.OrderResponse;
import com.ecomerce.springboot.entity.Order;
import com.ecomerce.springboot.entity.Payment;
import com.ecomerce.springboot.exception.PaymentException;
import com.ecomerce.springboot.repository.OrderRepository;
import com.ecomerce.springboot.repository.PaymentRepository;
import com.ecomerce.springboot.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;
    

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }


    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order =  orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);
        
        Payment payment = orderRequest.getPayment();
        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card typ do not support");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("Success");
        return orderResponse;
    }
    
}
