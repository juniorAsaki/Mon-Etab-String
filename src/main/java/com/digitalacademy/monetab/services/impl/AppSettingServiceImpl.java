package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.repositories.AppSettingRepository;
import com.digitalacademy.monetab.services.AppSettingService;
import com.digitalacademy.monetab.services.Mapping.AppSettingMapping;
import com.digitalacademy.monetab.services.dto.AppSettingDTO;
import com.digitalacademy.monetab.services.mapper.AppSettingMapper;
import com.digitalacademy.monetab.utils.SlugGifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Slf4j
public class AppSettingServiceImpl implements AppSettingService {

    private final AppSettingRepository appSettingRepository;
    private final AppSettingMapper appSettingMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<AppSettingDTO> findById(Long id) {
        return appSettingRepository.findById(id).map(appSetting -> appSettingMapper.ToDto(appSetting));
    }

    @Override
    public Optional<AppSettingDTO> findBySlug(String slug) {
        return appSettingRepository.findAppSettingBySlug(slug).map(appSettingMapper::ToDto);
    }

    @Override
    public AppSettingDTO save(AppSettingDTO appSettingDTO) {
        return appSettingMapper.ToDto(appSettingRepository.save(appSettingMapper.DtoToEntity(appSettingDTO)));
    }

    @Override
    public AppSettingDTO saveAppSettingDTO(AppSettingDTO appSettingDTO) {
        final String SLUG = SlugGifyUtils.generateSlug(appSettingDTO.getSmtpUsername());
        appSettingDTO.setSlug(SLUG);
        return save(appSettingDTO);
    }

    @Override
    public List<AppSettingDTO> findAll() {
        return appSettingRepository.findAll().stream().map(appSetting -> appSettingMapper.ToDto(appSetting)).toList();
    }

    @Override
    public AppSettingDTO update(AppSettingDTO appSettingDTO) {
        return findById(appSettingDTO.getId_appsetting()).map(appSetting -> {
            appSetting.setSmtpUsername(appSettingDTO.getSmtpUsername());
            appSetting.setSmtpPassword(passwordEncoder.encode(appSettingDTO.getSmtpPassword()));
            return save(appSetting);
        }).orElseThrow(() -> new RuntimeException("AppSettings not found !"));
    }

    @Override
    public AppSettingDTO update(AppSettingDTO appSettingDTO, Long id) {
        appSettingDTO.setId_appsetting(id);
        return update(appSettingDTO);
    }

    @Override
    public AppSettingDTO partialUpdate(AppSettingDTO appSettingDTO, Long id) {
        return appSettingRepository.findById(id).map(appSetting -> {
            AppSettingMapping.partialUpdate(appSetting, appSettingDTO);
            return appSetting;
        }).map(appSettingRepository::save).map(appSettingMapper::ToDto).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        appSettingRepository.deleteById(id);
    }

    @Override
    public AppSettingDTO initAppSetting(AppSettingDTO appSettingDTO) {
        log.debug("Request to init app {}", appSettingDTO);
        AppSettingDTO settingDTO = existingParameter();
        if (settingDTO == null) {
            return save(appSettingDTO);
        }

        return save(appSettingDTO);

    }

    @Override
    public AppSettingDTO existingParameter() {
        log.debug("Request to check existing parameter");
        List<AppSettingDTO> appSettingDTOS = findAll();
        return appSettingDTOS.stream().findFirst().orElse(null);
    }
}
