package com.example.Conditer.controller;

import com.example.Conditer.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String home(){
        return "main";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/contacts")
    public String contacts(){
        return "contacts";
    }

    @GetMapping("/menu")
    public String menu(){
        return "menu";
    }

//    @GetMapping("/order")
//    public String order(Model model){
//        model.addAttribute("order", new Order());
//        return "order";
//    }
}
