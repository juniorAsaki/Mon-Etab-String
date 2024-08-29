package com.digitalacademy.monetab.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
@Slf4j
public class ReportController {

    @GetMapping
    public String showRapportPage() {
        log.debug("show Rapport Page");

        return "report/default";
    }
}
