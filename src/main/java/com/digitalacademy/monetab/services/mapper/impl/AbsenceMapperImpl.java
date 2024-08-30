package com.digitalacademy.monetab.services.mapper.impl;

import com.digitalacademy.monetab.models.Absence;
import com.digitalacademy.monetab.repositories.AbsenceRepository;
import com.digitalacademy.monetab.services.dto.AbsenceDTO;
import com.digitalacademy.monetab.services.mapper.AbsenceMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AbsenceMapperImpl implements AbsenceMapper {

    private final ModelMapper modelMapper;

    @Override
    public AbsenceDTO ToDto(Absence entity) {
        return modelMapper.map(entity, AbsenceDTO.class);
    }

    @Override
    public Absence DtoToEntity(AbsenceDTO dto) {
        return modelMapper.map(dto, Absence.class);
    }
}
