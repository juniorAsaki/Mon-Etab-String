package com.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue(value = "teacher")
public class Teacher extends Person {

    @Column(name = "matiere", nullable = false)
    private String matiere;


}
