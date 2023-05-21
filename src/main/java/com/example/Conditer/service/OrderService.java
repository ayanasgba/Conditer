package com.example.Conditer.service;

import com.example.Conditer.entity.Order;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

public interface OrderService {

    Order saveOrder(Order order, String email);
}
