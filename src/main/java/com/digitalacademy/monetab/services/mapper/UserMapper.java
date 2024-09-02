package com.digitalacademy.monetab.services.mapper;

import com.digitalacademy.monetab.models.User;
import com.digitalacademy.monetab.services.dto.UserDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO , User> {
}
