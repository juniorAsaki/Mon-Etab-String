package com.digitalacademy.monetab.controllers;


import com.digitalacademy.monetab.services.StudentService;
import com.digitalacademy.monetab.services.TeacherService;
import com.digitalacademy.monetab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String home(Model model) {

        model.addAttribute("students", studentService.findAll());
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("users", userService.findAll());

        return "home/dashboard";
    }
}
