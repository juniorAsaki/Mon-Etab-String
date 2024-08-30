package com.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_school;

    @Column(nullable = false , name = "name_school")
    private String nameSchool;

    @Column(nullable = false , name = "url_logo")
    private String urlLogo;

    @OneToOne(cascade = CascadeType.ALL)
    private AppSetting appSetting;
}
