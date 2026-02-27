package com.example.RegistrationLogin.controllers;

import com.example.RegistrationLogin.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyController {


    @GetMapping("/regPage")
    public String openRegPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
}
