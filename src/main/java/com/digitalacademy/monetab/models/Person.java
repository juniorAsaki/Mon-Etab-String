package com.digitalacademy.monetab.models;

import com.digitalacademy.monetab.services.impl.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
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
public abstract class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_personne")
    private Long idPerson;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "numbers")
    private String numbers;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "url_picture")
    private String urlPicture;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(unique = true)
    private String slug;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adress")
    private Adress adress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;


}
