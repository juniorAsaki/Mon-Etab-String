package com.digitalacademy.monetab.services.mapper;

import com.digitalacademy.monetab.models.School;
import com.digitalacademy.monetab.services.dto.SchoolDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface SchoolMapper extends EntityMapper<SchoolDTO, School> {
}
