package com.digitalacademy.monetab.web.resources;


import com.digitalacademy.monetab.services.RoleUserService;
import com.digitalacademy.monetab.services.StudentService;
import com.digitalacademy.monetab.services.dto.*;
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

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/students")
public class StudentResource {

    private final StudentService studentService;
    private final RoleUserService roleUserService;

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

        // Récupérer les rôles associés à l'étudiant
        List<RoleUserDTO> roles = student.getUser().getRoleUser().stream().map(roleDTO -> roleUserService.findById(roleDTO.getIdRoleUser()).orElseThrow(() ->
                new RuntimeException("Role not found with id: " + roleDTO.getIdRoleUser()))).toList();

        student.getUser().setRoleUser(roles);
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
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

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdate(@RequestBody StudentDTO studentDTO, @PathVariable Long id) {
        log.debug("REST to request partial update {}", studentDTO);
        Optional<StudentDTO> student = studentService.findById(id);
        if (student.isPresent()) {
            return new ResponseEntity<>(studentService.partialUpdate(studentDTO, id), HttpStatus.OK);
        }

        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);

    }

    @PostMapping("update")
    public ResponseEntity<?> uploadPictureStudent(@ModelAttribute FileStudentDTO fileStudentDTO) throws IOException {
        log.debug("REST request to upload picture student");

        StudentDTO studentDTO = studentService.uploadStudentPicture(fileStudentDTO.getFile(), fileStudentDTO.getIdPerson());

        if (studentDTO != null) {
            return new ResponseEntity<>(studentDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
    }
}
