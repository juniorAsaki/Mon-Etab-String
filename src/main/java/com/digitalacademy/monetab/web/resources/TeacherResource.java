package com.digitalacademy.monetab.web.resources;


import com.digitalacademy.monetab.services.TeacherService;
import com.digitalacademy.monetab.services.dto.TeacherDTO;
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
@RequestMapping("api/teachers")
public class TeacherResource {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherDTO> saveTeacher(@RequestBody TeacherDTO teacherDTO) {
        log.debug("REST request to save Teacher : {}", teacherDTO);
        return new ResponseEntity<>(teacherService.save(teacherDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public TeacherDTO updateTeacher(@RequestBody TeacherDTO teacherDTO, @PathVariable Long id) {
        log.debug("REST request to update Teacher : {}", teacherDTO);
        return teacherService.update(teacherDTO, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        log.debug("REST request to delete Teacher : {}", id);
        teacherService.deleteById(id);
    }

    @GetMapping
    public List<TeacherDTO> getAllTeachers() {
        log.debug("REST request to get all Teachers");
        return teacherService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TeacherDTO> getTeacher(@PathVariable Long id) {
        log.debug("REST request to get Teacher : {}", id);
        return teacherService.findById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdate(@PathVariable Long id, @RequestBody TeacherDTO teacherDTO) {
        log.debug("REST request to partial update Teacher : {}", teacherDTO);

        Optional<TeacherDTO> optionalTeacher = teacherService.findById(id);
        if (optionalTeacher.isPresent()) {
            return new ResponseEntity<>(teacherService.partialUpdate(teacherDTO, id), HttpStatus.OK);
        }
        return new ResponseEntity<>("teacher not found", HttpStatus.NOT_FOUND);
    }
}
