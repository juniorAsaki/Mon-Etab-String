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
@Table(name = "adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country" , nullable = false)
    private String country;

    @Column(name = "city" , nullable = false)
    private String city;

    @Column(name = "street" , nullable = false)
    private String street;
}
