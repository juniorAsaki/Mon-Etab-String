package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.RoleUserDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleUserService {

    Optional<RoleUserDTO> FindById(Long id);
    RoleUserDTO save(RoleUserDTO roleUser);
    RoleUserDTO update(RoleUserDTO roleUser);
    void delete(Long id);
    List<RoleUserDTO> findAll();
    List<RoleUserDTO> initRoles(List<RoleUserDTO> roles);
}
