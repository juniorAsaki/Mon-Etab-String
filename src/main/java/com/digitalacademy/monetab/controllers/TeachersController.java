package com.digitalacademy.monetab.controllers;


import com.digitalacademy.monetab.models.Adress;
import com.digitalacademy.monetab.models.Student;
import com.digitalacademy.monetab.models.Teacher;
import com.digitalacademy.monetab.services.AdressService;
import com.digitalacademy.monetab.services.TeacherService;
import com.digitalacademy.monetab.services.impl.EnumMatiere;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teachers")
@Slf4j
public class TeachersController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private AdressService adressService;


    @GetMapping
    public String showTeachersPage(Model model) {

        model.addAttribute("teachers", teacherService.findAll());
        return "teachers/list";
    }

    @GetMapping("/add")
    public String showAddTeacherPage(
            Model model
    ){
        Teacher teacher = new Teacher();
        teacher.setAdress(new Adress());
        log.info("student {}" , teacher);
        model.addAttribute("teacher", teacher);
        model.addAttribute("enum_matieres" , EnumMatiere.values());
        model.addAttribute("action", "add");
        return "teachers/forms";
    }

    @GetMapping("/update/{id}")
    public String showUpdateTeacherPage(
            @PathVariable Long id,
            Model model
    ){
        model.addAttribute("teacher", teacherService.findById(id));
        model.addAttribute("enum_matieres" , EnumMatiere.values());
        model.addAttribute("action", "update");
        return "teachers/forms";
    }

    @PostMapping("/save")
    public String saveTeacher(Teacher teacher) {
        log.info("teacher {}" , teacher);

        adressService.save(teacher.getAdress());
        teacherService.save(teacher);

        return "redirect:/students";
    }
}
