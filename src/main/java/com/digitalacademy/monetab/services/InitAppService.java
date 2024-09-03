package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.AppSettingDTO;
import com.digitalacademy.monetab.services.dto.RoleUserDTO;
import com.digitalacademy.monetab.services.dto.SchoolDTO;

import java.util.List;



public interface InitAppService {

    AppSettingDTO initAppSetting(AppSettingDTO appSettingDTO);
    SchoolDTO initSchool(SchoolDTO schoolDTO , AppSettingDTO appSettingDTO);
    List<RoleUserDTO> initRoleUsers(List<RoleUserDTO> roleUserDTOList);
}
