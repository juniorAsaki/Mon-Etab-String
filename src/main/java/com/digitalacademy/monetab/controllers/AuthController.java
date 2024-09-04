package com.digitalacademy.monetab.controllers;


import com.digitalacademy.monetab.services.AppSettingService;
import com.digitalacademy.monetab.services.SchoolService;
import com.digitalacademy.monetab.services.UserService;

import com.digitalacademy.monetab.services.dto.SchoolDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final SchoolService schoolService;

    @Autowired
    private final AppSettingService appSettingService;

    @GetMapping
    public String showLoginPage(Model model) {
        SchoolDTO school = schoolService.findAll().stream().findFirst().get();
        log.debug("Request to show login page: {}", school);
        model.addAttribute("school", school);
       return "auth/login";
    }


}
