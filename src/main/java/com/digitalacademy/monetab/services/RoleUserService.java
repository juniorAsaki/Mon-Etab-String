package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.RoleUserDTO;

import java.util.Optional;

public interface RoleUserService {

    Optional<RoleUserDTO> FindById(Long id);
    RoleUserDTO save(RoleUserDTO roleUser);
    RoleUserDTO update(RoleUserDTO roleUser);
    void delete(Long id);
}
