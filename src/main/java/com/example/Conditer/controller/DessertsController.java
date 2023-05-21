package com.example.Conditer.controller;

import com.example.Conditer.entity.Desserts;
import com.example.Conditer.service.DessertsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DessertsController {
    private DessertsService dessertsService;

    public DessertsController(DessertsService dessertsService) {
        super();
        this.dessertsService = dessertsService;
    }

    @GetMapping("/desserts")
    public String listDesserts(Model model){
        model.addAttribute("desserts", dessertsService.getAllDesserts());
        return "desserts";
    }

    @GetMapping("/desserts/desserts_create")
    public String createDessertsForm(Model model){
        model.addAttribute("desserts", new Desserts());
        return "desserts_create";
    }

    @PostMapping("/desserts")
    public String saveDesserts(@ModelAttribute("desserts") Desserts desserts){
        dessertsService.saveDesserts(desserts);
        return "redirect:/desserts";
    }
    @GetMapping("/desserts/desserts_edit/{id}")
    public String editDessertsForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("desserts",dessertsService.getDessertsById(id));
        return "desserts_edit";
    }

    @PostMapping("/desserts/{id}")
    public String updateDesserts(@PathVariable Long id, @ModelAttribute("desserts") Desserts desserts, Model model){
        Desserts existingDesserts = dessertsService.getDessertsById(id);
        existingDesserts.setId(id);
        existingDesserts.setName(desserts.getName());
        existingDesserts.setDescription(desserts.getDescription());
        existingDesserts.setPrice(desserts.getPrice());

        dessertsService.updateDesserts(existingDesserts);
        return "redirect:/desserts";
    }

    @GetMapping("/desserts/{id}")
    public String deleteDesserts(@PathVariable Long id){
        dessertsService.deleteDessertsById(id);
        return "redirect:/desserts";
    }
}

