package com.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue(value = "student")
public class Student extends Person{

    @Column(unique=true , nullable=false , name = "matricule")
    private String matricule;

    @Column(name = "classe" , nullable = false)
    private String classe;

    @Column(name = "phone_number_father" , nullable = false)
    private String phoneNumberFather;

    @OneToMany( cascade = CascadeType.ALL , mappedBy = "student")
    private List<Absence> absence;
}
