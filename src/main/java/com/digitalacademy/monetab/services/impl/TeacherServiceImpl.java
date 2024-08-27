package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.models.Teacher;
import com.digitalacademy.monetab.repositories.TeacherRepository;
import com.digitalacademy.monetab.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
//        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacher.getId_teacher());
//
//        if(optionalTeacher.isPresent()){
//            Teacher teacherUpdate = optionalTeacher.get();
//
//            teacherUpdate.setMatiere(teacher.getMatiere());
//
//            return teacherRepository.save(teacherUpdate);
//        }else{
//            throw new IllegalArgumentException();
//        }
        return new Teacher();
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }
}
