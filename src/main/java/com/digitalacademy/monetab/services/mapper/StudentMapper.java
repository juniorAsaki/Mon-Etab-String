package com.digitalacademy.monetab.services.mapper;


import com.digitalacademy.monetab.models.Student;
import com.digitalacademy.monetab.services.dto.StudentDTO;

public final class StudentMapper{

    private StudentMapper(){}

    public static StudentDTO ToStudentDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId_person(student.getId_person());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setMatricule(student.getMatricule());
        studentDTO.setClasse(student.getClasse());
        studentDTO.setGenre(student.getGenre());
        studentDTO.setNumbers(student.getNumbers());
        studentDTO.setDateOfBirth(student.getDateOfBirth());
        studentDTO.setAdress(AdressMapper.toAdressDTO(student.getAdress()));

        return studentDTO;
    }

    public static Student ToStudent(StudentDTO studentDTO){
        Student student = new Student();
       student.setId_person(studentDTO.getId_person());
       student.setFirstName(studentDTO.getFirstName());
       student.setLastName(studentDTO.getLastName());
       student.setEmail(studentDTO.getEmail());
       student.setMatricule(studentDTO.getMatricule());
       student.setClasse(studentDTO.getClasse());
       student.setGenre(studentDTO.getGenre());
       student.setNumbers(studentDTO.getNumbers());
       student.setDateOfBirth(studentDTO.getDateOfBirth());
       student.setAdress(AdressMapper.toAdress(studentDTO.getAdress()));
       return student;
    }

}
