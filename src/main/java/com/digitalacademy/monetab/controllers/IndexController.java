package com.digitalacademy.monetab.controllers;


import com.digitalacademy.monetab.services.*;
import com.digitalacademy.monetab.services.dto.AppSettingDTO;
import com.digitalacademy.monetab.services.dto.SchoolDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@Slf4j
@RequiredArgsConstructor
public class IndexController {

    private final SchoolService schoolService;

    private final AppSettingService appSettingService;


    @GetMapping
    public String index(Model model) {

        List<SchoolDTO> schools = schoolService.findAll();
        List<AppSettingDTO> appSetting = appSettingService.findAll();

        if (appSetting.isEmpty()) {
            return "redirect:/settings";
        } else if (schools.isEmpty()) {
            return "redirect:/schools";
        } else {
            return "redirect:/connexion";
        }

    }

}
