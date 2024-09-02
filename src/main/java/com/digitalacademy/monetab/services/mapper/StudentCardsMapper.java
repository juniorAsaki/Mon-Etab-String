package com.digitalacademy.monetab.services.mapper;

import com.digitalacademy.monetab.models.StudentCards;
import com.digitalacademy.monetab.services.dto.StudentCardsDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface StudentCardsMapper extends EntityMapper<StudentCardsDTO , StudentCards> {
}
