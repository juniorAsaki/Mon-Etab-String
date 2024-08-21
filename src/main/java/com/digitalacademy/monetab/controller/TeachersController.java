package com.digitalacademy.monetab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teachers")
public class TeachersController {


    @GetMapping
    public String showTeachersPage(){
        return "teachers/list";
    }

    @GetMapping("/add")
    public String showAddTeacherPage(){
        return "teachers/forms";
    }

    @GetMapping("/update")
    public String showUpdateTeacherPage(){
        return "teachers/forms";
    }
}
