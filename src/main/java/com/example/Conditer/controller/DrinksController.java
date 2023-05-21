package com.example.Conditer.controller;

import com.example.Conditer.entity.Bakery;
import com.example.Conditer.entity.Drinks;
import com.example.Conditer.service.DrinksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DrinksController {

    private DrinksService drinksService;

    public DrinksController(DrinksService drinksService) {
        super();
        this.drinksService = drinksService;
    }

    @GetMapping("/drinks")
    public String listDrinks(Model model){
        model.addAttribute("drinks", drinksService.getAllDrinks());
        return "drinks";
    }

    @GetMapping("/drinks/drinks_create")
    public String createDrinksForm(Model model){
        model.addAttribute("drinks", new Drinks());
        return "drinks_create";
    }

    @PostMapping("/drinks")
    public String saveDrinks(@ModelAttribute("drinks") Drinks drinks){
        drinksService.saveDrinks(drinks);
        return "redirect:/drinks";
    }

    @GetMapping("/drinks/drinks_edit/{id}")
    public String editDrinksForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("drinks",drinksService.getDrinksById(id));
        return "drinks_edit";
    }

    @PostMapping("/drinks/{id}")
    public String updateDrinks(@PathVariable Long id, @ModelAttribute("drinks") Drinks drinks, Model model){
        Drinks existingDrinks = drinksService.getDrinksById(id);
        existingDrinks.setId(id);
        existingDrinks.setName(drinks.getName());
        existingDrinks.setDescription(drinks.getDescription());
        existingDrinks.setPrice(drinks.getPrice());

        drinksService.updateDrinks(existingDrinks);
        return "redirect:/drinks";
    }

    @GetMapping("/drinks/{id}")
    public String deleteDrinks(@PathVariable Long id){
        drinksService.deleteDrinksById(id);
        return "redirect:/drinks";
    }
}
