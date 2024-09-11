package com.digitalacademy.monetab.services.mapper;

import com.digitalacademy.monetab.models.Adress;
import com.digitalacademy.monetab.services.dto.AdressDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AdressMapper extends EntityMapper<AdressDTO, Adress> {
}
