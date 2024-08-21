package com.digitalacademy.monetab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {

    @GetMapping
    public String showUserPage(){
        return "users/list";
    }

    @GetMapping("/add")
    public String showAddUserPage(){
        return "users/forms";
    }

    @GetMapping("/update")
    public String showUpdateUserPage(){
        return "users/forms";
    }
}
