package com.digitalacademy.monetab.services.mapper.impl;

import com.digitalacademy.monetab.models.Adress;
import com.digitalacademy.monetab.services.dto.AdressDTO;
import com.digitalacademy.monetab.services.mapper.AdressMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdressMapperImpl implements AdressMapper {

    private final ModelMapper modelMapper;

    @Override
    public AdressDTO ToDto(Adress entity) {
        return modelMapper.map(entity, AdressDTO.class);
    }

    @Override
    public Adress DtoToEntity(AdressDTO dto) {
        return modelMapper.map(dto, Adress.class);
    }
}
