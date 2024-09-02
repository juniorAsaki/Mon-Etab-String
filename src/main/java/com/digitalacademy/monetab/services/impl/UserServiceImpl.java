package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.models.User;
import com.digitalacademy.monetab.repositories.UserRepository;
import com.digitalacademy.monetab.services.UserService;
import com.digitalacademy.monetab.services.dto.UserDTO;
import com.digitalacademy.monetab.services.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    private final UserMapper userMapper;
    //private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDTO save(UserDTO userDTO) {
        log.debug("Saving user {}", userDTO);

        User user  = userMapper.DtoToEntity(userDTO);
        return userMapper.ToDto(userRepository.save(user));
    }

    @Override
    public UserDTO update(UserDTO userDTO) {

        return findById(userDTO.getId_user()).map(existingUser ->{
            existingUser.setPseudo(userDTO.getPseudo());
            existingUser.setPassword(userDTO.getPassword());
            return save(existingUser);
        }).orElseThrow(()->new RuntimeException(""));
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        log.debug("Finding user by id {}", id);
        return userRepository.findById(id).map(userMapper::ToDto);
    }

    @Override
    public List<UserDTO> findAll() {
        log.debug("Finding all users");
        return userRepository.findAll().stream().map(userMapper::ToDto).toList();
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Deleting user by id {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDTO> findByPseudo(String pseudo) {

        return userRepository.findByPseudo(pseudo).map(user -> userMapper.ToDto(user));
    }

    @Override
    public List<UserDTO> initUsers(List<UserDTO> users) {

        List<UserDTO> userDTOS = findAll();
        if (userDTOS.isEmpty()){
            users.forEach(user -> save(user));
        }

        return findAll();
    }
}
