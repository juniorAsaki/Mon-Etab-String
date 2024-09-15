package com.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "app_setting")
public class AppSetting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_appsetting;

    @Column(unique = true, nullable = false, name = "smtp_server")
    private String smtpServer;

    @Column(unique = true, nullable = false, name = "smtp_port")
    private Integer smtpPort;

    @Column(unique = true, nullable = false, name = "smtp_username")
    private String smtpUsername;

    @Column(unique = true, nullable = false, name = "smtp_password")
    private String smtpPassword;

    @OneToOne(mappedBy = "appSetting")
    private School school;

    @Column(unique = true)
    private String slug;

}
