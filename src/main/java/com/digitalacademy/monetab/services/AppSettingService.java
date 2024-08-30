package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.AppSettingDTO;

import java.util.Optional;
import java.util.Set;

public interface AppSettingService {

    Optional<AppSettingDTO> findById(Long id);
    AppSettingDTO save(AppSettingDTO appSettingDTO);
    Set<AppSettingDTO> findAll();
    AppSettingDTO update(AppSettingDTO appSettingDTO);
    void deleteById(Long id);
}
