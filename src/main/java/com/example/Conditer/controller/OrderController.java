package com.example.Conditer.controller;

import com.example.Conditer.entity.Order;
import com.example.Conditer.entity.User;
import com.example.Conditer.service.OrderService;
import com.example.Conditer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.attribute.UserPrincipal;

@Controller
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        super();
        this.orderService = orderService;
    }

    @GetMapping
    public String order(Model model){
        model.addAttribute("order", new Order());
        return "order";
    }
    @PostMapping("/save")
    public String saveOrder(@ModelAttribute("order") Order order, Authentication authentication){
        orderService.saveOrder(order,authentication.getName());
        return "redirect:/order";
    }

}
