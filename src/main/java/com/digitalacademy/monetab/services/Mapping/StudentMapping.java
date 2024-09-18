package com.digitalacademy.monetab.services.Mapping;

import com.digitalacademy.monetab.models.Student;
import com.digitalacademy.monetab.services.dto.StudentDTO;

public final class StudentMapping {

    private StudentMapping() {
    }

    public static void partialUpdate(Student student, StudentDTO studentDTO) {

        if (studentDTO.getFirstName() != null) {
            student.setFirstName(studentDTO.getFirstName());
        }

        if (studentDTO.getLastName() != null) {
            student.setLastName(studentDTO.getLastName());
        }

        if (studentDTO.getMatricule() != null) {
            student.setMatricule(studentDTO.getMatricule());
        }
    }
}
