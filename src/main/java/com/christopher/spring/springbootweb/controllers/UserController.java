package com.christopher.spring.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model)
    {
        model.addAttribute("titulo", "gola mundo spring boot");
        model.addAttribute("nombre", "chrisotpher");
        model.addAttribute("apellido", "tumi");
        return "details";
    }
}
