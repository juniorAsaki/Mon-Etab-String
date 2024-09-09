package com.digitalacademy.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SchoolDTO {

    private Long id_school;

    private String nameSchool;

    private String urlLogo;

    private AppSettingDTO appSetting;
}
