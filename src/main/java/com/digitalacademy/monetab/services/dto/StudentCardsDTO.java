package com.digitalacademy.monetab.services.dto;

import com.digitalacademy.monetab.models.Student;
import java.sql.Date;

public class StudentCardsDTO {

    private Long id_student_card;

    private String reference;

    private Date issueDate;

    private Date expiryDate;

    private StudentDTO student;
}
