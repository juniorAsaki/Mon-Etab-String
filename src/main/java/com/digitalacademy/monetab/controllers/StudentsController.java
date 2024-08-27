package com.digitalacademy.monetab.controllers;


import com.digitalacademy.monetab.models.Adress;
import com.digitalacademy.monetab.models.Student;
import com.digitalacademy.monetab.services.AdressService;
import com.digitalacademy.monetab.services.StudentService;
import com.digitalacademy.monetab.services.impl.EnumClasse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/students")
@Slf4j
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private AdressService adressService;

    @GetMapping
    public String showStudentPage(Model model) {

        model.addAttribute("students", studentService.findAll());
        return "students/list";
    }

    @GetMapping("/add")
    public String showAddStudentPage(Model model) {
        Student student = new Student();
        student.setAdress(new Adress());
        model.addAttribute("student", student);
        model.addAttribute("enum_classes", EnumClasse.values());
        model.addAttribute("action", "add");
        return "students/forms";
    }

    @GetMapping("/update/{id}")
    public String showUpdateStudentPage(
            @PathVariable Long id ,
            Model model
    ) {
        Optional<Student> student = studentService.findById(id);
        if( student.isPresent()){
            model.addAttribute("student", student.get());
            model.addAttribute("enum_classes", EnumClasse.values());
            model.addAttribute("action", "update");
            return "students/forms";
        }else{
            return "redirect:/students";
        }


    }

    @PostMapping("/save")
    public String saveStudent(Student student) {
        log.info("student {}", student);

        adressService.save(student.getAdress());
        studentService.save(student);

        return "redirect:/students";
    }
}
