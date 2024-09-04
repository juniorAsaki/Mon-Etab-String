package com.digitalacademy.monetab.services.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class ExcelStudentDTO {

    private String matricule;

    private String firstName;

    private String lastName;

    private String numbers;

    private Date dateOfBirth;

}
