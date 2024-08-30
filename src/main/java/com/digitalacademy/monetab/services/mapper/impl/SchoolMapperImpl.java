package com.digitalacademy.monetab.services.mapper.impl;

import com.digitalacademy.monetab.models.School;
import com.digitalacademy.monetab.services.dto.SchoolDTO;
import com.digitalacademy.monetab.services.mapper.SchoolMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SchoolMapperImpl implements SchoolMapper {

    private final ModelMapper modelMapper;

    @Override
    public SchoolDTO ToDto(School entity) {
        return modelMapper.map(entity, SchoolDTO.class);
    }

    @Override
    public School DtoToEntity(SchoolDTO dto) {
        return modelMapper.map(dto, School.class);
    }
}
