package com.digitalacademy.monetab.web.resources;


import com.digitalacademy.monetab.services.StudentService;
import com.digitalacademy.monetab.services.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/students")
public class StudentResource {

    private final StudentService studentService;


    @PostMapping
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO student) {
        log.debug("REST request to save student {}", student);
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public StudentDTO updateStudent(@RequestBody StudentDTO student, @RequestParam Long id) {
        log.debug("REST request to update student {}", student);
        return studentService.update(student, id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        log.debug("REST request to delete student {}", id);
        studentService.deleteById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id) {
        log.debug("REST request to get student {}", id);

        Optional<StudentDTO> student = studentService.findById(id);

        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
    }


    @GetMapping
    public List<StudentDTO> getStudents() {
        log.debug("REST request to get students");
        return studentService.findAll();
    }
}
