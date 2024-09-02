package com.digitalacademy.monetab.services.mapper;

import com.digitalacademy.monetab.models.Absence;
import com.digitalacademy.monetab.services.dto.AbsenceDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AbsenceMapper extends EntityMapper<AbsenceDTO , Absence> {
}
