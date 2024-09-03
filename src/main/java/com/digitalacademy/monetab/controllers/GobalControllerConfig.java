package com.digitalacademy.monetab.controllers;


import com.digitalacademy.monetab.services.SchoolService;
import com.digitalacademy.monetab.services.dto.SchoolDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class GobalControllerConfig {

    @Autowired
    private SchoolService schoolService;

    @ModelAttribute
    public void addAttributes(Model model) {
            model.addAttribute("school",  schoolService.findAll().stream().findFirst().orElse(null));
        }

}
