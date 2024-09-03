package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.StudentDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;



public interface StudentService {

    StudentDTO save(StudentDTO studentDTO);
    StudentDTO update(StudentDTO studentDTO);
    Optional<StudentDTO> findById(Long id);
    List<StudentDTO> findAll();
    void deleteById(Long id);
    List<StudentDTO> findByLastNameOrGenderOrMatricule(String query , String gender);
}
