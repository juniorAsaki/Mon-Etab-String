package com.digitalacademy.monetab.services.mapper.impl;

import com.digitalacademy.monetab.models.RoleUser;
import com.digitalacademy.monetab.models.User;
import com.digitalacademy.monetab.services.dto.RoleUserDTO;
import com.digitalacademy.monetab.services.mapper.RoleUserMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class RoleUserMapperImpl implements RoleUserMapper {

    private final ModelMapper modelMapper;

    @Override
    public RoleUserDTO ToDto(RoleUser entity) {
        return modelMapper.map(entity , RoleUserDTO.class);
    }

    @Override
    public RoleUser DtoToEntity(RoleUserDTO dto) {
        return modelMapper.map(dto , RoleUser.class);
    }
}
