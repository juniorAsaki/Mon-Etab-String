package com.digitalacademy.monetab.services.mapper;

import com.digitalacademy.monetab.models.AppSetting;
import com.digitalacademy.monetab.services.dto.AppSettingDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppSettingMapper extends EntityMapper<AppSettingDTO, AppSetting> {
}
