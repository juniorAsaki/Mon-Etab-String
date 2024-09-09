package com.digitalacademy.monetab.controllers;


import com.digitalacademy.monetab.services.AppSettingService;
import com.digitalacademy.monetab.services.InitAppService;
import com.digitalacademy.monetab.services.dto.AppSettingDTO;
import com.digitalacademy.monetab.services.dto.SchoolDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/settings")
@Slf4j
@RequiredArgsConstructor
public class AppSettingController {

    private final InitAppService initAppService;
    private final AppSettingService appSettingService;

    @GetMapping
    public String showSettingPage(Model model) {
        Optional<AppSettingDTO> appSettingDTO = appSettingService.findAll().stream().findFirst();
        if (appSettingDTO.isPresent()) {
            return "redirect:/";
        }
        model.addAttribute("setting", new AppSettingDTO());
        return "inits/setting";
    }

    @GetMapping("update")
    public String showUpdatePage(Model model) {
        model.addAttribute("setting", appSettingService.findAll().stream().findFirst().get());

        return "inits/config_interne/setting";
    }

    @PostMapping
    public String saveSettingApp(AppSettingDTO appSettingDTO) {
        initAppService.initAppSetting(appSettingDTO);

        if (appSettingDTO.getId_appsetting() == null) {
            return "redirect:/schools";
        } else {
            return "redirect:/home";
        }
    }
}
