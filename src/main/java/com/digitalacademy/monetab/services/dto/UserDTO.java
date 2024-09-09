package com.digitalacademy.monetab.services.dto;

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

    private Boolean disable;

    private List<RoleUserDTO> roleUser;

    private SchoolDTO school;

}
