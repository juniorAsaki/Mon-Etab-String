package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.services.*;
import com.digitalacademy.monetab.services.dto.AppSettingDTO;
import com.digitalacademy.monetab.services.dto.RoleUserDTO;
import com.digitalacademy.monetab.services.dto.SchoolDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class InitAppServiceImpl implements InitAppService {


    @Autowired
    private AppSettingService appSettingService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private RoleUserService roleUserService;

    @Autowired
    private UserService userService;


    @Override
    public AppSettingDTO initAppSetting(AppSettingDTO appSettingDTO) {
        return appSettingService.initAppSetting(appSettingDTO);
    }

    @Override
    public SchoolDTO initSchool(SchoolDTO schoolDTO, AppSettingDTO appSettingDTO) {
        schoolDTO.setAppSetting(appSettingDTO);
        return schoolService.initSchool(schoolDTO);
    }

    @Override
    public List<RoleUserDTO> initRoleUsers(List<RoleUserDTO> roleUserDTOList) {
        return roleUserService.initRoles(roleUserDTOList);
    }


}
