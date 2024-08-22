package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.models.Student;
import com.digitalacademy.monetab.models.Teacher;
import com.digitalacademy.monetab.repositories.StudentRepository;
import com.digitalacademy.monetab.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());

        if(optionalStudent.isPresent()){
            Student studentUpdate = optionalStudent.get();

            studentUpdate.setMatricule(student.getMatricule());

            return studentRepository.save(studentUpdate);
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
