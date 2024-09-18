package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.models.Teacher;
import com.digitalacademy.monetab.repositories.TeacherRepository;
import com.digitalacademy.monetab.services.Mapping.TeacherMapping;
import com.digitalacademy.monetab.services.TeacherService;
import com.digitalacademy.monetab.services.dto.TeacherDTO;
import com.digitalacademy.monetab.services.mapper.TeacherMapper;
import com.digitalacademy.monetab.utils.SlugGifyUtils;
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
    public TeacherDTO saveTeacher(TeacherDTO teacherDTO) {
        final String SLUG = SlugGifyUtils.generateSlug(teacherDTO.getFirstName());
        teacherDTO.setSlug(SLUG);
        return save(teacherDTO);
    }

    @Override
    public TeacherDTO update(TeacherDTO teacherDTO) {

        return findById(teacherDTO.getIdPerson()).map(existingTeacher -> {
            Teacher teacher = teacherMapper.DtoToEntity(teacherDTO);
            teacher.setLastName(existingTeacher.getLastName());
            return save(existingTeacher);
        }).orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    @Override
    public TeacherDTO update(TeacherDTO teacherDTO, Long id) {
        TeacherDTO teacher = findById(id).orElseThrow(() -> new RuntimeException("Teacher not found"));

        if (teacher != null) {
            teacher.setLastName(teacherDTO.getLastName());
            teacher.setFirstName(teacherDTO.getFirstName());
            teacher.setAvailable(teacherDTO.getAvailable());
        }
        return save(teacher);
    }

    @Override
    public TeacherDTO partialUpdate(TeacherDTO teacherDTO, Long id) {
        return teacherRepository.findById(id).map(teacher -> {
            TeacherMapping.partialUpdate(teacher, teacherDTO);
            return teacher;
        }).map(teacherRepository::save).map(teacherMapper::ToDto).orElse(null);
    }

    @Override
    public Optional<TeacherDTO> findById(Long id) {
        return teacherRepository.findById(id).map(teacher -> teacherMapper.ToDto(teacher));
    }

    @Override
    public Optional<TeacherDTO> findBySlug(String slug) {
        return teacherRepository.findBySlug(slug).map(teacherMapper::ToDto);
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

    @Override
    public List<TeacherDTO> findByLastNameOrSpecialtyAndGender(String query, String gender) {
        List<Teacher> teachers = teacherRepository.findByLastNameOrSpecialtyAndGender(query, query, Gender.valueOf(gender));
        return teachers.stream().map(teacher -> teacherMapper.ToDto(teacher)).toList();
    }
}
