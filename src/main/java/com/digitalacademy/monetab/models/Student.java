package com.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@ToString
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_student;

    @Column(name = "matricule" , nullable = false)
    private String matricule;
}
