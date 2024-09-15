package com.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "role_user")
@ToString
public class RoleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role_user")
    private Long idRoleUser;

    @Column(unique = true, name = "name_role")
    private String nameRole;

    @Column(unique = true)
    private String slug;
}
