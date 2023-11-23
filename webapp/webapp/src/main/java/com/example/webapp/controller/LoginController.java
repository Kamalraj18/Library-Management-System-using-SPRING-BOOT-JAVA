package com.example.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webapp.ENTITY.Register;
import com.example.webapp.repository.RegisterRepository;



@Controller
@RequestMapping("/Login")
public class LoginController {

@Autowired
private RegisterRepository regRepository;

    @GetMapping
    public String LoginPage(){
        return "Main";
    }


    @GetMapping("/Register")
    public String RegisterPageForm(Model model){
        model.addAttribute("register", new Register());
        return "Register";
    }

    @PostMapping("/Register")
    public String RegisterPage(@ModelAttribute Register register){
        regRepository.save(register);
        return "redirect:/Login";

    }



}
