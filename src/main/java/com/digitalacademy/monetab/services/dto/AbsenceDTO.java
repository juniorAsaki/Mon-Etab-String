package com.digitalacademy.monetab.services.dto;

import com.digitalacademy.monetab.models.Student;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class AbsenceDTO {

    private Long id_absence;

    private Date dateAbsence;

    private int numberAbsence;

    private StudentDTO student;
}
