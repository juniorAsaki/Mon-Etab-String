package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.RegistrationStudentDTO;
import com.digitalacademy.monetab.services.dto.ResponseRegisterStudentDTO;
import com.digitalacademy.monetab.services.dto.StudentDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface StudentService {

    StudentDTO save(StudentDTO studentDTO);

    StudentDTO saveStudent(StudentDTO studentDTO);

    StudentDTO update(StudentDTO studentDTO);

    StudentDTO update(StudentDTO studentDTO, Long id);

    StudentDTO partialUpdate(StudentDTO studentDTO, Long id);

    Optional<StudentDTO> findById(Long id);

    Optional<StudentDTO> findBySlug(String slug);

    List<StudentDTO> findAll();

    void deleteById(Long id);

    List<StudentDTO> findByLastNameOrGenderOrMatricule(String query, String gender);

    ResponseRegisterStudentDTO registerStudent(RegistrationStudentDTO registrationStudentDTO);

    StudentDTO uploadStudentPicture(MultipartFile file, Long id) throws IOException;

}
