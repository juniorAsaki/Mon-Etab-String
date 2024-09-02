package com.digitalacademy.monetab.controllers;


import com.digitalacademy.monetab.models.User;
import com.digitalacademy.monetab.services.AppSettingService;
import com.digitalacademy.monetab.services.SchoolService;
import com.digitalacademy.monetab.services.UserService;
import com.digitalacademy.monetab.services.dto.AppSettingDTO;
import com.digitalacademy.monetab.services.dto.SchoolDTO;
import com.digitalacademy.monetab.services.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        log.debug("show login page");

        List<SchoolDTO> schools = schoolService.findAll();
        List<AppSettingDTO> appSettings = appSettingService.findAll();

        if(schools.isEmpty() && appSettings.isEmpty()) {
            return "redirect:/";
        }else if(schools.isEmpty()) {
            return "redirect:/school";
        }else {
            SchoolDTO school = schools.get(0);
            model.addAttribute("user", new UserDTO());
            model.addAttribute("school", school);
            return "auth/login";
        }
    }

    @PostMapping("save")
    public String submitForm(@ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult) {
        log.debug("submit form {}", userDTO);
        String url = null;

        Optional<UserDTO> userConnexion = userService.findByPseudo(userDTO.getPseudo());
        if (userConnexion.isPresent()) {
            url =  "redirect:/home";
        }else{
            url =  "redirect:/login";
        }

        return url;

    }

}
