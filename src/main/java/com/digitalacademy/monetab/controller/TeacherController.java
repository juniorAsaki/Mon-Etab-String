package com.digitalacademy.monetab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teachers")
public class TeacherController {


    @GetMapping
    public String showTeachersPage(){
        return "gestionProfesseur/teachers";
    }

    @GetMapping("/add")
    public String showAddTeacherPage(){
        return "gestionProfesseur/addTeacher";
    }

    @GetMapping("/update")
    public String showUpdateTeacherPage(){
        return "gestionProfesseur/updateTeacher";
    }
}
