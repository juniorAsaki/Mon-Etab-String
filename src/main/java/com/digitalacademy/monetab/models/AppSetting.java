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
@Table(name = "app_setting")
public class AppSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_appsetting;

    @Column(unique = true, nullable = false)
    private String smtpServer;

    @Column(unique = true, nullable = false)
    private String smtpPort;

    @Column(unique = true, nullable = false)
    private String smtpUsername;

    @Column(unique = true, nullable = false)
    private String smtpPassword;

    @OneToOne(mappedBy = "appSetting")
    private School school;
}
