package com.digitalacademy.monetab.controllers;


import com.digitalacademy.monetab.models.Student;
import com.digitalacademy.monetab.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String showStudentPage(Model model) {

        model.addAttribute("students", studentService.findAll());
        return "students/list";
    }

    @GetMapping("/add")
    public String showAddStudentPage(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("action", "add");
        return "students/forms";
    }

    @GetMapping("/update/{id}")
    public String showUpdateStudentPage(
            @PathVariable Long id ,
            Model model
    ) {
        model.addAttribute("student", studentService.findById(id));
        model.addAttribute("action", "update");
        return "students/forms";
    }
}
