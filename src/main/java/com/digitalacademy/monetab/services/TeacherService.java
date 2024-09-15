package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.models.Teacher;
import com.digitalacademy.monetab.services.dto.TeacherDTO;

import java.util.List;
import java.util.Optional;


public interface TeacherService {

    TeacherDTO save(TeacherDTO teacherDTO);

    TeacherDTO saveTeacher(TeacherDTO teacherDTO);

    TeacherDTO update(TeacherDTO teacherDTO);

    TeacherDTO update(TeacherDTO teacherDTO, Long id);

    Optional<TeacherDTO> findById(Long id);

    Optional<TeacherDTO> findBySlug(String slug);

    List<TeacherDTO> findAll();

    void deleteById(Long id);

    List<TeacherDTO> findByLastNameOrSpecialtyAndGender(String query, String gender);
}
