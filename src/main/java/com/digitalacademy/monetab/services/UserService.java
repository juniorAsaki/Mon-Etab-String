package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {


    User save(User user);
    User update(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    void deleteById(Long id);
}
