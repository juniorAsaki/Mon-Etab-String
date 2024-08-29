package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.models.Student;
import com.digitalacademy.monetab.services.dto.StudentDTO;

import java.util.List;
import java.util.Optional;



public interface StudentService {

    StudentDTO save(StudentDTO studentDTO);
    StudentDTO update(StudentDTO studentDTO);
    Optional<StudentDTO> findById(Long id);
    List<StudentDTO> findAll();
    void deleteById(Long id);
}
