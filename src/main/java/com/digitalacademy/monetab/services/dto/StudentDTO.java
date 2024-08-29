package com.digitalacademy.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDTO extends PersonDTO{

    private String matricule;

    private String classe;
}
