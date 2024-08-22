package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.models.Adress;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AdressService {

    Adress save(Adress adress);
    Adress update(Adress adress);
    Optional<Adress> findById(Long id);
    List<Adress> findAll();
    void deleteById(Long id);
}
