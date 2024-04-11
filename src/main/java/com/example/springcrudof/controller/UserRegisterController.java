package com.example.springcrudof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springcrudof.dto.UserRegisterDTO;
import com.example.springcrudof.service.UserService;

@Controller
@RequestMapping("/register-user")
public class UserRegisterController {
    
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegisterDTO userRegisterDTO() {
        return new UserRegisterDTO();
    }

    @GetMapping
    public String showRegisterForm() {
        return "register-user";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegisterDTO userRegisterDTO) {
        userService.saveUser(userRegisterDTO);
        return "redirect:/register_user?success";
    }
}
