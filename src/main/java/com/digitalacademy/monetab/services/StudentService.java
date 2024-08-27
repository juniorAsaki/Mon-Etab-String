package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.models.Student;

import java.util.List;
import java.util.Optional;



public interface StudentService {

    Student save(Student student);
    Student update(Student student);
    Optional<Student> findById(Long id);
    List<Student> findAll();
    void deleteById(Long id);
}
