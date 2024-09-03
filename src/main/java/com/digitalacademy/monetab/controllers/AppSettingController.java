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

@Controller
@RequestMapping("/settings")
@Slf4j
@RequiredArgsConstructor
public class AppSettingController {

    private final InitAppService initAppService;

    @GetMapping
    public String showSettingPage(Model model){
        model.addAttribute("setting" , new AppSettingDTO());
        return "inits/setting";
    }

    @PostMapping
    public String saveSettingApp(AppSettingDTO appSettingDTO) {
        initAppService.initAppSetting(appSettingDTO);
        return "redirect:/schools";
    }
}
