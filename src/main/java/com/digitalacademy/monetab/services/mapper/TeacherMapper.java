package com.digitalacademy.monetab.services.mapper;

import com.digitalacademy.monetab.models.Teacher;
import com.digitalacademy.monetab.services.dto.TeacherDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TeacherMapper extends EntityMapper<TeacherDTO, Teacher> {
}
