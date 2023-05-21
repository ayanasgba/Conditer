package com.example.Conditer.controller;
import com.example.Conditer.entity.Bakery;
import com.example.Conditer.entity.Icecream;
import com.example.Conditer.service.IcecreamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IcecreamController {
    private IcecreamService icecreamService;

    public IcecreamController(IcecreamService icecreamService) {
        super();
        this.icecreamService = icecreamService;
    }

    @GetMapping("/icecream")
    public String listIcecream(Model model){
        model.addAttribute("icecream", icecreamService.getAllIcecream());
        return "icecream";
    }

    @GetMapping("/icecream/icecream_create")
    public String createIcecreamForm(Model model){
        model.addAttribute("icecream", new Icecream());
        return "icecream_create";
    }

    @PostMapping("/icecream")
    public String saveIcecream(@ModelAttribute("icecream") Icecream icecream){
        icecreamService.saveIcecream(icecream);
        return "redirect:/icecream";
    }

    @GetMapping("/icecream/icecream_edit/{id}")
    public String editIcecreamForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("icecream", icecreamService.getIcecreamById(id));
        return "icecream_edit";
    }

    @PostMapping("/icecream/{id}")
    public String updateIcecream(@PathVariable Long id, @ModelAttribute("icecream") Icecream icecream, Model model){
        Icecream existingIcecream = icecreamService.getIcecreamById(id);
        existingIcecream.setId(id);
        existingIcecream.setName(icecream.getName());
        existingIcecream.setDescription(icecream.getDescription());
        existingIcecream.setPrice(icecream.getPrice());

        icecreamService.updateIcecream(existingIcecream);
        return "redirect:/icecream";
    }

    @GetMapping("/icecream/{id}")
    public String deleteIcecream(@PathVariable Long id){
        icecreamService.deleteIcecreamById(id);
        return "redirect:/icecream";
    }
}