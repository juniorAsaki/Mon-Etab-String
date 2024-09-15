package com.digitalacademy.monetab.web.resources;


import com.digitalacademy.monetab.services.StudentService;
import com.digitalacademy.monetab.services.dto.RegistrationStudentDTO;
import com.digitalacademy.monetab.services.dto.ResponseRegisterStudentDTO;
import com.digitalacademy.monetab.services.dto.StudentDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @PostMapping("/register-student")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseRegisterStudentDTO registerStudent(@RequestBody RegistrationStudentDTO registrationStudentDTO) {
        log.debug("Registering student: {}", registrationStudentDTO);
        return studentService.registerStudent(registrationStudentDTO);
    }


    @PostMapping
    @ApiResponse(responseCode = "200", description = "Request to save Student")
    @Operation(summary = "save new student", description = "this endpoint allow to save student")
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO student) {
        log.debug("REST request to save student {}", student);
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "201", description = "Request to update Student")
    public StudentDTO updateStudent(@RequestBody StudentDTO student, @PathVariable Long id) {
        log.debug("REST request to update student {}", student);
        return studentService.update(student, id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to delete Student")
    public void deleteStudent(@PathVariable Long id) {
        log.debug("REST request to delete student {}", id);
        studentService.deleteById(id);
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to get Student")
    public ResponseEntity<?> getOneStudent(
            @Parameter(required = true, description = "ID of student to be retrieved")
            @PathVariable Long id
    ) {
        log.debug("REST request to get student {}", id);
        Optional<StudentDTO> student = studentService.findById(id);

        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
    }


    @GetMapping
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200", description = "Request to get Students"),
                    @ApiResponse(responseCode = "404", description = "Students not found", content = @Content(schema = @Schema(implementation = String.class)))
            }
    )
    public List<StudentDTO> getAlStudents() {
        log.debug("REST request to get students");
        return studentService.findAll();
    }
}
