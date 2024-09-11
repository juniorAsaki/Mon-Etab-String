package com.digitalacademy.monetab.repositories;

import com.digitalacademy.monetab.models.Student;
import com.digitalacademy.monetab.services.impl.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    //    etape 1)
    List<Student> findByLastNameIgnoreCaseOrMatriculeIgnoreCaseAndGender(String lastName, String matricule, Gender gender);

}
