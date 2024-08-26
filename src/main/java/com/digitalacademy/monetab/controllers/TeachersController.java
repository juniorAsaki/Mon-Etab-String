package com.digitalacademy.monetab.controllers;


import com.digitalacademy.monetab.models.Teacher;
import com.digitalacademy.monetab.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teachers")
public class TeachersController {

    @Autowired
    private TeacherService teacherService;


    @GetMapping
    public String showTeachersPage(Model model) {

        model.addAttribute("teachers", teacherService.findAll());
        return "teachers/list";
    }

    @GetMapping("/add")
    public String showAddTeacherPage(
            Model model
    ){
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("action", "add");
        return "teachers/forms";
    }

    @GetMapping("/update/{id}")
    public String showUpdateTeacherPage(
            @PathVariable Long id,
            Model model
    ){
        model.addAttribute("teacher", teacherService.findById(id));
        model.addAttribute("action", "update");
        return "teachers/forms";
    }
}
