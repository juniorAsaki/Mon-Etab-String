package com.digitalacademy.monetab.services.Mapping;

import com.digitalacademy.monetab.models.Teacher;
import com.digitalacademy.monetab.services.dto.TeacherDTO;

public final class TeacherMapping {

    private TeacherMapping() {
    }

    public static void partialUpdate(Teacher teacher, TeacherDTO teacherDTO) {

        if (teacherDTO.getFirstName() != null) {
            teacher.setFirstName(teacherDTO.getFirstName());
        }

        if (teacherDTO.getLastName() != null) {
            teacher.setLastName(teacherDTO.getLastName());
        }

        if (teacherDTO.getSpecialty() != null) {
            teacher.setSpecialty(teacherDTO.getSpecialty());
        }
    }
}
