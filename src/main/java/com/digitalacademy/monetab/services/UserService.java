package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.models.User;
import com.digitalacademy.monetab.services.dto.UserDTO;

import java.util.List;
import java.util.Optional;


public interface UserService {


    UserDTO save(UserDTO userDTO);
    UserDTO update(UserDTO userDTO);
    Optional<UserDTO> findById(Long id);
    List<UserDTO> findAll();
    void deleteById(Long id);
    Optional<UserDTO> findByPseudo(String username);
}
