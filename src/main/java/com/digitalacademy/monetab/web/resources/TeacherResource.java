package com.digitalacademy.monetab.web.resources;


import com.digitalacademy.monetab.services.TeacherService;
import com.digitalacademy.monetab.services.dto.TeacherDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/teachers")
public class TeacherResource {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherDTO> saveTeacher(@RequestBody TeacherDTO teacherDTO) {
        log.debug("REST request to save Teacher : {}", teacherDTO);
        return new ResponseEntity<>(teacherService.save(teacherDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeacher(@RequestBody TeacherDTO teacherDTO, @PathVariable Long id) {
        log.debug("REST request to update Teacher : {}", teacherDTO);

        return null;
    }
}
