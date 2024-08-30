package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.models.Teacher;
import com.digitalacademy.monetab.repositories.TeacherRepository;
import com.digitalacademy.monetab.services.TeacherService;
import com.digitalacademy.monetab.services.dto.TeacherDTO;
import com.digitalacademy.monetab.services.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
        Teacher teacher = teacherMapper.DtoToEntity(teacherDTO);
        return teacherMapper.ToDto(teacherRepository.save(teacher));
    }

    @Override
    public TeacherDTO update(TeacherDTO teacherDTO) {

        return findById(teacherDTO.getId_person()).map(existingTeacher ->{
            Teacher teacher = teacherMapper.DtoToEntity(teacherDTO);
            teacher.setEmail(existingTeacher.getEmail());
            teacher.setMatiere(existingTeacher.getMatiere());
            return save(existingTeacher);
        }).orElseThrow(()-> new RuntimeException("Teacher not found"));
    }

    @Override
    public Optional<TeacherDTO> findById(Long id) {
        return teacherRepository.findById(id).map(teacher -> teacherMapper.ToDto(teacher));
    }

    @Override
    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream().map(teacher -> {
            return teacherMapper.ToDto(teacher);
        }).toList();
    }

    @Override
    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }
}
