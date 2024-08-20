package com.digitalacademy.monetab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping()
    public String showStudentPage() {
        return "/gestionEleve/student";
    }

    @GetMapping("/add")
    public String showAddStudentPage() {
        return "/gestionEleve/addStudent";
    }

    @GetMapping("/update")
    public String showUpdateStudentPage() {
        return "/gestionEleve/updateStudent";
    }
}
