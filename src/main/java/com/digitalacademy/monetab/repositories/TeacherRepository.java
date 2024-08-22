package com.digitalacademy.monetab.repositories;

import com.digitalacademy.monetab.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
