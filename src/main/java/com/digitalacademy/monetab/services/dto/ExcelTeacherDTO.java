package com.digitalacademy.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class ExcelTeacherDTO {

    private Boolean available;

    private String specialty;

    private String firstName;

    private String lastName;

    private String numbers;

    private Date dateOfBirth;


}
