package com.digitalacademy.monetab.controllers;

import com.digitalacademy.monetab.services.AdressService;
import com.digitalacademy.monetab.services.UserService;
import com.digitalacademy.monetab.services.dto.AdressDTO;
import com.digitalacademy.monetab.services.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdressService adressService;


    @GetMapping
    public String showUserPage(Model model) {
        log.debug("show user page ");
        System.out.println(userService.findAll());

        model.addAttribute("users", userService.findAll());
        return "users/list";
    }

    @GetMapping("/add")
    public String showAddUserPage(Model model){
        log.debug("show add user page");

        UserDTO userDTO = new UserDTO();
        userDTO.setAdress(new AdressDTO());

        // Log pour vérifier l'initialisation
        log.debug("UserDTO initialized: {}", userDTO);

        model.addAttribute("user", userDTO);
        model.addAttribute("action", "add");
        return "users/forms";
    }

    @GetMapping("/update/{id}")
    public String showUpdateUserPage(@PathVariable Long id, Model model)
    {
        log.debug("show update user page {}" , id);

        Optional<UserDTO> userDTO = userService.findById(id);

        System.out.println(userDTO.isPresent());

        if(userDTO.isPresent()){
            model.addAttribute("user", userDTO);
            model.addAttribute("action", "update");
            return "users/forms";
        }else{
            return "redirect:/users";
        }

    }

    @PostMapping("/save")
    public String saveUser(UserDTO userDTO){
        log.debug("save user {}", userDTO);
        userDTO.setCreatedDate(Instant.now());
        userService.save(userDTO);
        return "redirect:/users";

    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        log.debug("delete user {}", id);

        if(userService.findById(id).isPresent()){
            userService.deleteById(id);
        }

        return "redirect:/users";

    }
}
