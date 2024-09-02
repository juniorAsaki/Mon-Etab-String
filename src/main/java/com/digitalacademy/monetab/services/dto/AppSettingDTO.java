package com.digitalacademy.monetab.services.dto;

import com.digitalacademy.monetab.models.School;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AppSettingDTO {

    private Long id_appsetting;

    private String smtpServer;

    private String smtpPort;

    private String smtpUsername;

    private String smtpPassword;

}
