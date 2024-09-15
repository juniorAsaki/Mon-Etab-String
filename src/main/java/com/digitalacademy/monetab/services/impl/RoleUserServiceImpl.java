package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.repositories.RoleUserRepository;
import com.digitalacademy.monetab.services.RoleUserService;
import com.digitalacademy.monetab.services.dto.RoleUserDTO;
import com.digitalacademy.monetab.services.mapper.RoleUserMapper;
import com.digitalacademy.monetab.utils.SlugGifyUtils;
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
    public Optional<RoleUserDTO> findById(Long id) {
        return roleUserRepository.findById(id).map(roleUser -> roleUserMapper.ToDto(roleUser));
    }

    @Override
    public Optional<RoleUserDTO> findBySlug(String slug) {
        return roleUserRepository.findBySlug(slug).map(roleUserMapper::ToDto);
    }

    @Override
    public RoleUserDTO save(RoleUserDTO roleUser) {
        return roleUserMapper.ToDto(roleUserRepository.save(roleUserMapper.DtoToEntity(roleUser)));
    }

    @Override
    public RoleUserDTO saveRoleUser(RoleUserDTO roleUser) {
        final String SLUG = SlugGifyUtils.generateSlug(roleUser.getNameRole());
        roleUser.setSlug(SLUG);
        return save(roleUser);
    }

    @Override
    public RoleUserDTO update(RoleUserDTO roleUser) {
        return findById(roleUser.getIdRoleUser()).map(roleUserDTO -> {
            roleUserDTO.setNameRole(roleUser.getNameRole());
            return save(roleUserDTO);
        }).orElseThrow(() -> new RuntimeException("Role User Not Found"));
    }

    @Override
    public RoleUserDTO update(RoleUserDTO roleUser, Long id) {
        roleUser.setIdRoleUser(id);
        return update(roleUser);
    }

    @Override
    public void delete(Long id) {
        roleUserRepository.deleteById(id);
    }

    @Override
    public List<RoleUserDTO> findAll() {
        return roleUserRepository.findAll().stream().map(roleUser -> roleUserMapper.ToDto(roleUser)).toList();
    }

    @Override
    public List<RoleUserDTO> initRoles(List<RoleUserDTO> roles) {
        log.debug("Request to init roles {}", roles);
        List<RoleUserDTO> listRoles = findAll();

        if (listRoles.isEmpty()) {
            roles.forEach(roleUserDTO -> save(roleUserDTO));
        }
        return findAll();
    }

    @Override
    public List<RoleUserDTO> findByRole(String roleUser) {
        return roleUserRepository.findByNameRole(roleUser).stream().map(roleUserMapper::ToDto).toList();
    }


}
