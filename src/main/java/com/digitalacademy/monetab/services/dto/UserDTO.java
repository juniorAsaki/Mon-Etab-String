package com.digitalacademy.monetab.services.dto;

import com.digitalacademy.monetab.models.Adress;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
public class UserDTO {

    private Long id_user;

    private String pseudo;

    private String password;

    private Instant createdDate;

    private AdressDTO adress;
}
