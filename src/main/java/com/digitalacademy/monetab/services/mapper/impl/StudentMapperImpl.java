package com.digitalacademy.monetab.services.mapper.impl;

import com.digitalacademy.monetab.models.Student;
import com.digitalacademy.monetab.services.dto.StudentDTO;
import com.digitalacademy.monetab.services.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapperImpl implements StudentMapper {

    private final ModelMapper modelMapper;

    @Override
    public StudentDTO ToDto(Student entity) {
        return modelMapper.map(entity, StudentDTO.class);
    }

    @Override
    public Student DtoToEntity(StudentDTO dto) {
        return modelMapper.map(dto, Student.class);
    }
}
