package com.digitalacademy.monetab.repositories;

import com.digitalacademy.monetab.models.Teacher;
import com.digitalacademy.monetab.services.impl.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByLastNameOrSpecialtyAndGender(String lastName, String specialty, Gender gender);
}
