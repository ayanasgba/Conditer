package com.example.Conditer.controller;

import com.example.Conditer.entity.Cakes;
import com.example.Conditer.service.CakesService;
import jakarta.jws.WebParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CakesController {

    private CakesService cakesService;

    public CakesController(CakesService cakesService){
        super();
        this.cakesService = cakesService;
    }

    @GetMapping("/cakes")
    public String listCakes(Model model){
        model.addAttribute("cakes", cakesService.getAllCakes());
        return "cakes";
    }

    @GetMapping("/cakes/cakes_create")
    public String createCakesForm(Model model){
        model.addAttribute("cakes",new Cakes());
        return "cakes_create";
    }

    @PostMapping("/cakes")
    public String saveCakes(@ModelAttribute("cakes") Cakes cakes){
        cakesService.saveCakes(cakes);
        return "redirect:/cakes";
    }

    @GetMapping("/cakes/cakes_edit/{id}")
    public String editCakesForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("cakes", cakesService.getCakesById(id));
        return "cakes_edit";
    }

    @PostMapping("/cakes/{id}")
    public String updateCakes(@PathVariable Long id, @ModelAttribute("cakes") Cakes cakes, Model model){
        Cakes existingCakes = cakesService.getCakesById(id);
        existingCakes.setId(id);
        existingCakes.setName(cakes.getName());
        existingCakes.setDescription(cakes.getDescription());
        existingCakes.setPrice(cakes.getPrice());

        cakesService.updateCakes(existingCakes);
        return "redirect:/cakes";
    }

    @GetMapping("/cakes/{id}")
    public String deleteCakes(@PathVariable Long id){
        cakesService.deleteCakesById(id);
        return "redirect:/cakes";
    }
}


