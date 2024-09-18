package com.digitalacademy.monetab.services.Mapping;

import com.digitalacademy.monetab.models.AppSetting;
import com.digitalacademy.monetab.services.dto.AppSettingDTO;

public final class AppSettingMapping {

    private AppSettingMapping() {
    }

    public static void partialUpdate(AppSetting appSetting, AppSettingDTO appSettingDTO) {

        if (appSettingDTO.getSmtpPort() != null) {
            appSetting.setSmtpPort(Integer.parseInt(appSettingDTO.getSmtpPort()));
        }

        if (appSettingDTO.getSmtpUsername() != null) {
            appSetting.setSmtpUsername(appSettingDTO.getSmtpUsername());
        }
    }
}
