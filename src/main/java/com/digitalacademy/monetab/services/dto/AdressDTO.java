package com.digitalacademy.monetab.services.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdressDTO {

    private Long id_adress;

    private String country;

    private String city;

    private String street;
}
