package com.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue(value = "teacher")
@ToString
public class Teacher extends Person {

    @Column(name = "matiere", nullable = false)
    private String matiere;


}
