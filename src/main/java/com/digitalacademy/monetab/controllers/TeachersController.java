package com.digitalacademy.monetab.controllers;


import com.digitalacademy.monetab.models.Adress;
import com.digitalacademy.monetab.services.AdressService;
import com.digitalacademy.monetab.services.TeacherService;
import com.digitalacademy.monetab.services.dto.AdressDTO;
import com.digitalacademy.monetab.services.dto.StudentDTO;
import com.digitalacademy.monetab.services.dto.TeacherDTO;
import com.digitalacademy.monetab.services.impl.Gender;
import com.digitalacademy.monetab.services.impl.Matieres;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
@Slf4j
@RequiredArgsConstructor
public class TeachersController {

    private final TeacherService teacherService;

    @GetMapping
    public String showTeachersPage(Model model) {
        log.debug("show teachers page");
        model.addAttribute("teachers", teacherService.findAll());
        return "teachers/list";
    }

    @GetMapping("/add")
    public String showAddTeacherPage(
            Model model
    ) {
        log.debug("show add teacher page");

        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setAdress(new AdressDTO());

        log.info("student {}", teacherDTO);

        model.addAttribute("teacher", teacherDTO);
        model.addAttribute("matieres", Matieres.values());
        model.addAttribute("genres", Gender.values());

        model.addAttribute("action", "add");

        return "teachers/forms";
    }

    @GetMapping("/update/{id}")
    public String showUpdateTeacherPage(
            @PathVariable Long id,
            Model model
    ) {
        log.debug("show update teacher page {}", id);

        model.addAttribute("teacher", teacherService.findById(id));
        model.addAttribute("matieres", Matieres.values());
        model.addAttribute("action", "update");
        model.addAttribute("genres", Gender.values());
        return "teachers/forms";
    }

    @PostMapping("/save")
    public String saveTeacher(TeacherDTO teacherDTO) {
        log.debug("teacher {}", teacherDTO);
        teacherService.save(teacherDTO);
        return "redirect:/teachers";
    }

    @PostMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        log.debug("delete teacher : {}", id);

        if (teacherService.findById(id).isPresent()) {
            teacherService.deleteById(id);
        }

        return "redirect:/teachers";
    }

    @GetMapping("/search")
    public String searchTeachers(@RequestParam String query, @RequestParam String gender, Model model) {
        List<TeacherDTO> teachers = teacherService.findByLastNameOrSpecialtyAndGender(query, gender);
        model.addAttribute("teachers", teachers);
        model.addAttribute("query", query);
        model.addAttribute("gender", gender);

        return "teachers/list";
    }
}
