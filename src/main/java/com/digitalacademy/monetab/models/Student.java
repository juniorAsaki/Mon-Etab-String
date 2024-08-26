package com.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue(value = "student")
public class Student extends Person{

    @Column(unique=true , nullable=false , name = "matricule")
    private String matricule;
}
