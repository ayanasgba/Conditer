package com.example.Conditer.service.impl;

import com.example.Conditer.entity.Order;
import com.example.Conditer.repository.OrderRepository;
import com.example.Conditer.service.OrderService;
import com.example.Conditer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderSaveImpl implements OrderService {

    private OrderRepository orderRepository;
    private UserService userService;

    @Autowired
    public OrderSaveImpl(OrderRepository orderRepository, UserService userService) {
        super();
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    @Override
    public Order saveOrder(Order order, String email) {
        order.setUser(userService.findByEmail(email));
        return orderRepository.save(order);
    }
}
