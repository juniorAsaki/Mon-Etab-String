package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.models.Teacher;

import java.util.List;
import java.util.Optional;


public interface TeacherService {

    Teacher save(Teacher teacher);
    Teacher update(Teacher teacher);
    Optional<Teacher> findById(Long id);
    List<Teacher> findAll();
    void deleteById(Long id);
}
