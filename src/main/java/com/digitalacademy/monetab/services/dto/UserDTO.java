package com.digitalacademy.monetab.services.dto;

import com.digitalacademy.monetab.models.Adress;
import com.digitalacademy.monetab.models.RoleUser;
import com.digitalacademy.monetab.models.School;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@ToString
public class UserDTO {

    private Long id_user;

    private String pseudo;

    private String password;

    private Instant createdDate;

    private List<RoleUserDTO> roleUser;

    private SchoolDTO school;

}
