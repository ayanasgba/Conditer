package com.example.Conditer.controller;
import com.example.Conditer.entity.Bakery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.Conditer.service.BakeryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BakeryController {
    private BakeryService bakeryService;

    public BakeryController(BakeryService bakeryService){
        super();
        this.bakeryService = bakeryService;
    }

    @GetMapping("/bakery")
    public String listBakery(Model model){
        model.addAttribute("bakery", bakeryService.getAllBakery());
        return "bakery";
    }

    @GetMapping("/bakery/bakery_create")
    public String createBakeryForm(Model model){
        model.addAttribute("bakery", new Bakery());
        return "bakery_create";
    }

    @PostMapping("/bakery")
    public String saveBakery(@ModelAttribute("bakery") Bakery bakery){
        bakeryService.saveBakery(bakery);
        return "redirect:/bakery";
    }

    @GetMapping("/bakery/bakery_edit/{id}")
    public String editBakeryForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("bakery", bakeryService.getBakeryById(id));
        return "bakery_edit";
    }

    @PostMapping("/bakery/{id}")
    public String updateBakery(@PathVariable Long id, @ModelAttribute("bakery") Bakery bakery, Model model){
        Bakery existingBakery = bakeryService.getBakeryById(id);
        existingBakery.setId(id);
        existingBakery.setName(bakery.getName());
        existingBakery.setDescription(bakery.getDescription());
        existingBakery.setPrice(bakery.getPrice());
        existingBakery.setPhoto(bakery.getPhoto());

        bakeryService.updateBakery(existingBakery);
        return "redirect:/bakery";
    }

    @GetMapping("/bakery/{id}")
    public String deleteBakery(@PathVariable Long id){
        bakeryService.deleteBakeryById(id);
        return "redirect:/bakery";
    }
}

