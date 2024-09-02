package com.digitalacademy.monetab.services.mapper;

import com.digitalacademy.monetab.models.RoleUser;
import com.digitalacademy.monetab.services.dto.RoleUserDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface RoleUserMapper extends EntityMapper<RoleUserDTO  , RoleUser> {
}
