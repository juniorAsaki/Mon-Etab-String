package com.digitalacademy.monetab.services.mapper.impl;

import com.digitalacademy.monetab.models.User;
import com.digitalacademy.monetab.services.dto.UserDTO;
import com.digitalacademy.monetab.services.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapperImpl implements UserMapper {

   private final ModelMapper modelMapper;

    @Override
    public UserDTO ToDto(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }

    @Override
    public User DtoToEntity(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }
}
