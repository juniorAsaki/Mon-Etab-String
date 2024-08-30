package com.digitalacademy.monetab.services.mapper.impl;

import com.digitalacademy.monetab.models.StudentCards;
import com.digitalacademy.monetab.services.dto.StudentCardsDTO;
import com.digitalacademy.monetab.services.mapper.StudentCardsMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class StudentCardsMapperImpl implements StudentCardsMapper {

    private final ModelMapper modelMapper;

    @Override
    public StudentCardsDTO ToDto(StudentCards entity) {
        return modelMapper.map(entity, StudentCardsDTO.class);
    }

    @Override
    public StudentCards DtoToEntity(StudentCardsDTO dto) {
        return modelMapper.map(dto, StudentCards.class);
    }
}
