package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.repositories.AppSettingRepository;
import com.digitalacademy.monetab.services.AppSettingService;
import com.digitalacademy.monetab.services.dto.AppSettingDTO;
import com.digitalacademy.monetab.services.mapper.AppSettingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public Optional<AppSettingDTO> findById(Long id) {
        return appSettingRepository.findById(id).map(appSetting -> appSettingMapper.ToDto(appSetting));
    }

    @Override
    public AppSettingDTO save(AppSettingDTO appSettingDTO) {
        return appSettingMapper.ToDto(appSettingRepository.save(appSettingMapper.DtoToEntity(appSettingDTO)));
    }

    @Override
    public List<AppSettingDTO> findAll() {
        return appSettingRepository.findAll().stream().map(appSetting -> appSettingMapper.ToDto(appSetting)).toList();
    }

    @Override
    public AppSettingDTO update(AppSettingDTO appSettingDTO) {
        return appSettingMapper.ToDto(appSettingRepository.save(appSettingMapper.DtoToEntity(appSettingDTO)));
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
