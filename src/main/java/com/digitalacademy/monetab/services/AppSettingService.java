package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.AppSettingDTO;

import java.util.List;
import java.util.Optional;

public interface AppSettingService {

    Optional<AppSettingDTO> findById(Long id);

    Optional<AppSettingDTO> findBySlug(String slug);

    AppSettingDTO save(AppSettingDTO appSettingDTO);

    AppSettingDTO saveAppSettingDTO(AppSettingDTO appSettingDTO);

    List<AppSettingDTO> findAll();

    AppSettingDTO update(AppSettingDTO appSettingDTO);

    AppSettingDTO update(AppSettingDTO appSettingDTO, Long id);

    AppSettingDTO partialUpdate(AppSettingDTO appSettingDTO, Long id);

    void deleteById(Long id);

    AppSettingDTO initAppSetting(AppSettingDTO appSettingDTO);

    AppSettingDTO existingParameter();
}
