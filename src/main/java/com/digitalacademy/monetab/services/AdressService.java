package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.AdressDTO;

import java.util.List;
import java.util.Optional;

public interface AdressService {

    AdressDTO save(AdressDTO adressDTO);
    AdressDTO update(AdressDTO adressDTO);
    Optional<AdressDTO> findById(Long id);
    List<AdressDTO> findAll();
    void deleteById(Long id);
}
