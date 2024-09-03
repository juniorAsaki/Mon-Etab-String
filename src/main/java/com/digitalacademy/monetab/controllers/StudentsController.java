package com.digitalacademy.monetab.controllers;



import com.digitalacademy.monetab.models.Adress;
import com.digitalacademy.monetab.services.StudentService;
import com.digitalacademy.monetab.services.dto.AdressDTO;
import com.digitalacademy.monetab.services.dto.StudentDTO;
import com.digitalacademy.monetab.services.impl.Gender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
@Slf4j
@RequiredArgsConstructor
public class StudentsController {

    private final StudentService studentService;


    @GetMapping
    public String showStudentPage(Model model) {
        log.debug("Showing students page");
        model.addAttribute("students", studentService.findAll());
        return "students/list";
    }

    @GetMapping("/add")
    public String showAddStudentPage(Model model) {
        log.debug("show add student page");

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setAdress(new AdressDTO());

        model.addAttribute("student", studentDTO);
        model.addAttribute("action", "add");
        model.addAttribute("genres", Gender.values());
        return "students/forms";
    }

    @GetMapping("/update/{id}")
    public String showUpdateStudentPage(
            @PathVariable Long id ,
            Model model
    ) {
        log.debug("show update student page {}" , id);

        Optional<StudentDTO> studentDTO = studentService.findById(id);
        if( studentDTO.isPresent()){
            model.addAttribute("student", studentDTO.get());
            model.addAttribute("action", "update");
            model.addAttribute("genres", Gender.values());
            return "students/forms";
        }else{
            return "redirect:/students";
        }


    }

    @PostMapping("/save")
    public String saveStudent(StudentDTO studentDTO) {
        log.info("student {}", studentDTO);
        studentService.save(studentDTO);
        return "redirect:/students";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        log.debug("delete student {}", id);

        if(studentService.findById(id).isPresent()){
            studentService.deleteById(id);
        }
        return "redirect:/students";
    }

    @GetMapping("/search")
    public String searchStudents(@RequestParam String query  ,@RequestParam String gender, Model model)
    {
        List<StudentDTO> students = studentService.findByLastNameOrGenderOrMatricule(query , gender);
        model.addAttribute("students", students);
        model.addAttribute("query", query);
        model.addAttribute("gender", gender);

        return "students/list";
    }
}
