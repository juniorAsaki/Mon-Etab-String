package com.digitalacademy.monetab.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentsController {

    @GetMapping
    public String showStudentPage() {
        return "students/list";
    }

    @GetMapping("/add")
    public String showAddStudentPage() {
        return "students/forms";
    }

    @GetMapping("/update")
    public String showUpdateStudentPage() {
        return "students/forms";
    }
}
