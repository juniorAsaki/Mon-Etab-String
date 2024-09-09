package com.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(name = "pseudo", unique = true, nullable = false)
    private String pseudo;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "creation_date", nullable = false)
    private Instant createdDate;

    @Column(name = "desable")
    private Boolean disable;

    @OneToMany(fetch = FetchType.EAGER)
    private List<RoleUser> roleUser;

    @ManyToOne
    @JoinColumn(name = "id_school")
    private School school;


}
