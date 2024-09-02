package com.digitalacademy.monetab.services.dto;

import com.digitalacademy.monetab.models.Absence;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class StudentDTO extends PersonDTO{

    private String matricule;

    private List<AbsenceDTO> absence;

    private String phoneNumberParent;

}
