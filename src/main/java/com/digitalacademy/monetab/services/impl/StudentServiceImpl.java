package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.models.Student;
import com.digitalacademy.monetab.repositories.StudentRepository;
import com.digitalacademy.monetab.services.StudentService;
import com.digitalacademy.monetab.services.dto.StudentDTO;
import com.digitalacademy.monetab.services.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        Student student = StudentMapper.ToStudent(studentDTO);
        return StudentMapper.ToStudentDTO(studentRepository.save(student));
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
        return findById((studentDTO.getId_person())).map(existingStudent ->{
            existingStudent.setAdress(studentDTO.getAdress());
            existingStudent.setEmail(studentDTO.getEmail());
            existingStudent.setFirstName(studentDTO.getFirstName());
            return save(existingStudent);
        }).orElseThrow(()-> new RuntimeException("Student not found"));
    }

    @Override
    public Optional<StudentDTO> findById(Long id) {
        return studentRepository.findById(id).map(student -> StudentMapper.ToStudentDTO(student));
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(student -> {
            return StudentMapper.ToStudentDTO(student);
        }).toList();
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
