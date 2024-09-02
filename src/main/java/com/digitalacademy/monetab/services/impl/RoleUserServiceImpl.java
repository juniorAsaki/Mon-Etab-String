package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.repositories.RoleUserRepository;
import com.digitalacademy.monetab.services.RoleUserService;
import com.digitalacademy.monetab.services.dto.RoleUserDTO;
import com.digitalacademy.monetab.services.mapper.RoleUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Slf4j
public class RoleUserServiceImpl implements RoleUserService {

    private final RoleUserRepository roleUserRepository;
    private final RoleUserMapper roleUserMapper;

    @Override
    public Optional<RoleUserDTO> FindById(Long id) {
        return roleUserRepository.findById(id).map(roleUser -> roleUserMapper.ToDto(roleUser));
    }

    @Override
    public RoleUserDTO save(RoleUserDTO roleUser) {
        return roleUserMapper.ToDto(roleUserRepository.save(roleUserMapper.DtoToEntity(roleUser)));
    }

    @Override
    public RoleUserDTO update(RoleUserDTO roleUser) {
        return roleUserMapper.ToDto(roleUserRepository.save(roleUserMapper.DtoToEntity(roleUser)));
    }

    @Override
    public void delete(Long id) {
        roleUserRepository.deleteById(id);
    }

    @Override
    public List<RoleUserDTO> findAll() {
        return  roleUserRepository.findAll().stream().map(roleUser -> roleUserMapper.ToDto(roleUser)).toList();
    }
}
