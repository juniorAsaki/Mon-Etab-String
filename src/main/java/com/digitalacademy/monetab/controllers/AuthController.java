package com.digitalacademy.monetab.controllers;


import com.digitalacademy.monetab.services.AppSettingService;
import com.digitalacademy.monetab.services.SchoolService;
import com.digitalacademy.monetab.services.UserService;

import com.digitalacademy.monetab.services.dto.AppSettingDTO;
import com.digitalacademy.monetab.services.dto.SchoolDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("connexion")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final SchoolService schoolService;


    @GetMapping
    public String showLoginPage(Model model) {
        log.debug("Request to show login page:");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser")) {
            return "redirect:/home";
        }

        model.addAttribute("school", schoolService.findAll().stream().findFirst().get());
        return "auth/login";
    }


}
