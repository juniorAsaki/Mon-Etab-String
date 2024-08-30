package com.digitalacademy.monetab.services.mapper.impl;

import com.digitalacademy.monetab.models.Teacher;
import com.digitalacademy.monetab.services.dto.TeacherDTO;
import com.digitalacademy.monetab.services.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherMapperImpl implements TeacherMapper {

    private final ModelMapper modelMapper;

    @Override
    public TeacherDTO ToDto(Teacher entity) {
        return modelMapper.map(entity, TeacherDTO.class);
    }

    @Override
    public Teacher DtoToEntity(TeacherDTO dto) {
        return modelMapper.map(dto, Teacher.class);
    }
}
