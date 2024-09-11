package com.digitalacademy.monetab.services.dto;


import com.digitalacademy.monetab.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleUserDTO {

    private Long idRoleUser;

    private String nameRole;

    private User user;
}
