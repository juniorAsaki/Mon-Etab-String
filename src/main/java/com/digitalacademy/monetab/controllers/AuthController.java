package com.digitalacademy.monetab.controllers;


import com.digitalacademy.monetab.models.User;
import com.digitalacademy.monetab.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final UserService userService;

    @GetMapping
    public String showLoginPage(Model model) {

        model.addAttribute("user", new User());
        return "auth/login";
    }

    @PostMapping("/login")
    public String submitForm(@ModelAttribute("user") User user, BindingResult bindingResult) {
        String url = null;

        Optional<User> userConnexion = userService.findByPseudo(user.getPseudo());
        if (userConnexion.isPresent()) {
            url =  "redirect:/home";
        }else{
            url =  "redirect:/";
        }

        return url;

    }

}
