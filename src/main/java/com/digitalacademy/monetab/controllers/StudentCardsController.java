package com.digitalacademy.monetab.controllers;

import com.digitalacademy.monetab.models.Student;
import com.digitalacademy.monetab.services.StudentCardsService;
import com.digitalacademy.monetab.services.StudentService;
import com.digitalacademy.monetab.services.dto.StudentCardsDTO;
import com.digitalacademy.monetab.services.dto.StudentDTO;
import com.digitalacademy.monetab.services.impl.Gender;
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
@RequestMapping("cards")
@Slf4j
public class StudentCardsController {

    @Autowired
    private StudentCardsService studentCardsService;

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String showStudentCards(Model model) {
        log.info("Show student cards");
        model.addAttribute("cards", studentCardsService.findAll());

        return "cards/list";
    }

    @GetMapping("add")
    public String showAddStudentCard(Model model) {
        log.info("Show add student card");

        StudentCardsDTO studentCardsDTO = new StudentCardsDTO();
        studentCardsDTO.setStudent(new StudentDTO());

        model.addAttribute("card", studentCardsDTO);
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("action", "add");

        return "cards/forms";
    }

    @GetMapping("update/{id}")
    public String showUpdateStudentCardPage(
            @PathVariable Long id,
            Model model
    ) {

        log.info("Show update student card");

        model.addAttribute("card", studentCardsService.findById(id));
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("action", "add");

        return "cards/forms";
    }

    @PostMapping("save")
    public String saveStudentCard(StudentCardsDTO studentCardsDTO) {
        log.info("Save student card {}", studentCardsDTO.getStudent().getIdPerson());
        studentCardsService.save(studentCardsDTO);
        return "redirect:/cards";
    }


    @PostMapping("delete/{id}")
    public String deleteStudentCard(@PathVariable Long id) {
        log.debug("delete student {}", id);
        studentCardsService.delete(id);

        return "redirect:/cards";
    }

}
