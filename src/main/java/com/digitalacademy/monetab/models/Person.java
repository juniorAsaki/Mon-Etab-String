package com.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "person_type")
@Table(name = "person")
@ToString
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_personne")
    private Long id_person;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName" , nullable = false)
    private String lastName;

    @Column(name = "email" , nullable = false)
    private String email;

    @Column(name = "numbers" , nullable = false)
    private String numbers;

    @Column(name = "dateOfBirth" , nullable = false)
    private Date dateOfBirth;

    @Column(name = "genre")
    private String genre;

    @OneToOne
    @JoinColumn(name = "id_adress")
    private Adress adress;


}
