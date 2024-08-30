package com.digitalacademy.monetab.services.mapper.impl;

import com.digitalacademy.monetab.models.AppSetting;
import com.digitalacademy.monetab.services.dto.AppSettingDTO;
import com.digitalacademy.monetab.services.mapper.AppSettingMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class AppSettingMapperImpl implements AppSettingMapper {

    private final ModelMapper modelMapper;

    @Override
    public AppSettingDTO ToDto(AppSetting entity) {
        return modelMapper.map(entity, AppSettingDTO.class);
    }

    @Override
    public AppSetting DtoToEntity(AppSettingDTO dto) {
        return modelMapper.map(dto, AppSetting.class);
    }
}
