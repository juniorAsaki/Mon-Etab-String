package com.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity(name = "Student")
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue(value = "student")
@ToString
public class Student extends Person{

    @Column(unique=true , nullable=false , name = "matricule")
    private String matricule;

    @OneToMany(  mappedBy = "student" , fetch = FetchType.EAGER)
    @Column(nullable = true)
    private List<Absence> absence;

    @Column(name = "phone_number_parent" , nullable = false)
    private String phoneNumberParent;


}
