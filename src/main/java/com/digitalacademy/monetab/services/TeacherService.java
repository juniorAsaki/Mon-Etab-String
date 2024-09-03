package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.models.Teacher;
import com.digitalacademy.monetab.services.dto.TeacherDTO;

import java.util.List;
import java.util.Optional;


public interface TeacherService {

    TeacherDTO save(TeacherDTO teacherDTO);
    TeacherDTO update(TeacherDTO teacherDTO);
    Optional<TeacherDTO> findById(Long id);
    List<TeacherDTO> findAll();
    void deleteById(Long id);
    List<TeacherDTO> findByLastNameOrSpecialtyAndGender(String query, String gender);
}
