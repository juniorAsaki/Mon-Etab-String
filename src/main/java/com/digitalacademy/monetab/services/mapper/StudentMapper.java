package com.digitalacademy.monetab.services.mapper;

import com.digitalacademy.monetab.models.Student;
import com.digitalacademy.monetab.services.dto.StudentDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface StudentMapper extends EntityMapper<StudentDTO, Student> {
}
