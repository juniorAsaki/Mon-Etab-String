package com.digitalacademy.monetab.services.dto;

import com.digitalacademy.monetab.models.Adress;
import com.digitalacademy.monetab.models.User;
import com.digitalacademy.monetab.services.impl.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;


@Getter
@Setter
@ToString
public class PersonDTO {


    private Long idPerson;

    private String firstName;

    private String lastName;

    private String numbers;

    private Date dateOfBirth;

    private String urlPicture;

    private Gender gender;

    private AdressDTO adress;

    private UserDTO user;

    private String slug;

}
