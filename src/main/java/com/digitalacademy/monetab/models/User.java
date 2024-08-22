package com.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

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
    private Long id;

    @Column(name = "pseudo" , unique = true , nullable = false)
    private String pseudo;

    @Column(name = "password" , nullable = false)
    private String password;

    @Column(name = "creation_date" , nullable = false)
    private Instant createdDate;
}
