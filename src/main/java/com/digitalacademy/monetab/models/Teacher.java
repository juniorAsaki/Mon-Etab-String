package com.digitalacademy.monetab.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher")
public class Teacher{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_teacher;

    @Column(name = "matiere", nullable = false)
    private String matiere;


    @OneToMany(fetch = FetchType.LAZY , mappedBy = "teacher")
    private Set<FileNote> fileNote;

    @Override
    public String toString() {
        return "Teacher{" +
                "id_teacher=" + id_teacher +
                ", matiere='" + matiere + '\'' +
                '}';
    }
}
