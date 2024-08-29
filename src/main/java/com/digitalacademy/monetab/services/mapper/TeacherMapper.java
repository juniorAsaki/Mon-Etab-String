package com.digitalacademy.monetab.services.mapper;

import com.digitalacademy.monetab.models.Teacher;
import com.digitalacademy.monetab.services.dto.TeacherDTO;

public final class TeacherMapper{

    private TeacherMapper(){}

    public static TeacherDTO ToTeacherDTO(Teacher teacher){
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId_person(teacher.getId_person());
        teacherDTO.setLastName(teacher.getLastName());
        teacherDTO.setFirstName(teacher.getFirstName());
        teacherDTO.setEmail(teacher.getEmail());
        teacherDTO.setGenre(teacher.getGenre());
        teacherDTO.setMatiere(teacher.getMatiere());
        teacherDTO.setNumbers(teacher.getNumbers());
        teacherDTO.setDateOfBirth(teacher.getDateOfBirth());
        teacherDTO.setAdress(AdressMapper.toAdressDTO(teacher.getAdress()));

        return teacherDTO;
    }

    public static Teacher ToTeacher(TeacherDTO teacherDTO){
        Teacher teacher = new Teacher();
        teacher.setId_person(teacherDTO.getId_person());
        teacher.setLastName(teacherDTO.getLastName());
        teacher.setFirstName(teacherDTO.getFirstName());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setGenre(teacherDTO.getGenre());
        teacher.setMatiere(teacherDTO.getMatiere());
        teacher.setNumbers(teacherDTO.getNumbers());
        teacher.setDateOfBirth(teacherDTO.getDateOfBirth());
        teacher.setAdress(AdressMapper.toAdress(teacherDTO.getAdress()));
        return teacher;
    }


}
