package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.RoleUserDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleUserService {

    Optional<RoleUserDTO> findById(Long id);

    Optional<RoleUserDTO> findBySlug(String slug);

    RoleUserDTO save(RoleUserDTO roleUser);

    RoleUserDTO saveRoleUser(RoleUserDTO roleUser);

    RoleUserDTO update(RoleUserDTO roleUser);

    RoleUserDTO update(RoleUserDTO roleUser, Long id);

    void delete(Long id);

    List<RoleUserDTO> findAll();

    List<RoleUserDTO> initRoles(List<RoleUserDTO> roles);

    List<RoleUserDTO> findByRole(String roleUser);
}
