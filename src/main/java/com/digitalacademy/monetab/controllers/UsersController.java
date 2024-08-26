package com.digitalacademy.monetab.controllers;

import com.digitalacademy.monetab.models.User;
import com.digitalacademy.monetab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;


    @GetMapping
    public String showUserPage(Model model) {

        model.addAttribute("users", userService.findAll());
        return "users/list";
    }

    @GetMapping("/add")
    public String showAddUserPage(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("action", "add");
        return "users/forms";
    }

    @GetMapping("/update/{id}")
    public String showUpdateUserPage(@PathVariable Long id, Model model)
    {
        Optional<User> user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("action", "update");
        return "users/forms";
    }
}
