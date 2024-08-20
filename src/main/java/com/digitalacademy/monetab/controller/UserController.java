package com.digitalacademy.monetab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String showUserPage(){
        return "gestionUtilisateur/users";
    }

    @GetMapping("/add")
    public String showAddUserPage(){
        return "gestionUtilisateur/addUser";
    }

    @GetMapping("/update")
    public String showUpdateUserPage(){
        return "gestionUtilisateur/updateUser";
    }
}
