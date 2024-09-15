package com.digitalacademy.monetab.services.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseRegisterStudentDTO {

    @JsonIgnoreProperties({"idPerson", "phoneNumberParent", "numbers", "dateOfBirth", "urlPicture", "gender", "adress", "user"})
    private StudentDTO student;

    @JsonIgnoreProperties({"id_adress"})
    private AdressDTO adress;
}
