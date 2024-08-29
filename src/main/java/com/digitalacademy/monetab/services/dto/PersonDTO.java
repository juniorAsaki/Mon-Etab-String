package com.digitalacademy.monetab.services.dto;

import com.digitalacademy.monetab.models.Adress;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;


@Getter
@Setter
@ToString
public class PersonDTO {


    private Long id_person;

    private String firstName;

    private String lastName;

    private String email;

    private String numbers;

    private Date dateOfBirth;

    private String genre;

    private AdressDTO adress;
}
