package com.example.Conditer.controller;

import com.example.Conditer.entity.Bakery;
import com.example.Conditer.entity.Pies;
import com.example.Conditer.service.PiesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PiesController {
    private PiesService piesService;

    public PiesController(PiesService piesService) {
        super();
        this.piesService = piesService;
    }

    @GetMapping("/pies")
    public String listPies(Model model){
        model.addAttribute("pies", piesService.getAllPies());
        return "pies";
    }
    @GetMapping("/pies/pies_create")
    public String createPiesForm(Model model){
        model.addAttribute("pies", new Pies());
        return "pies_create";
    }

    @PostMapping("/pies")
    public String savePies(@ModelAttribute("pies") Pies pies){
        piesService.savePies(pies);
        return "redirect:/pies";
    }

    @GetMapping("/pies/pies_edit/{id}")
    public String editPiesForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("pies", piesService.getPiesById(id));
        return "pies_edit";
    }

    @PostMapping("/pies/{id}")
    public String updatePies(@PathVariable Long id, @ModelAttribute("pies") Pies pies, Model model){
        Pies existingPies = piesService.getPiesById(id);
        existingPies.setId(id);
        existingPies.setDescription(pies.getDescription());
        existingPies.setPrice(pies.getPrice());

        piesService.updatePies(existingPies);
        return "redirect:/pies";
    }

    @GetMapping("/pies/{id}")
    public String deletePies(@PathVariable Long id){
        piesService.deletePiesById(id);
        return "redirect:/pies";
    }
}
