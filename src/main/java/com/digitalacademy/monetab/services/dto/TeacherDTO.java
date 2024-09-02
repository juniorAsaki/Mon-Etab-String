package com.digitalacademy.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TeacherDTO extends PersonDTO{

    private Boolean available;

    private String specialty;

}
