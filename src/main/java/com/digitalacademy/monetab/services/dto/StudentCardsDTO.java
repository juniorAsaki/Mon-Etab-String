package com.digitalacademy.monetab.services.dto;

import com.digitalacademy.monetab.models.Student;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
public class StudentCardsDTO {

    private Long idStudentCard;

    private String reference;

    private Date issueDate;

    private Date expiryDate;

    private StudentDTO student;
}
