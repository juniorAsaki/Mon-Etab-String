package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.AdressDTO;

import java.util.List;
import java.util.Optional;

public interface AdressService {

    AdressDTO save(AdressDTO adressDTO);

    AdressDTO saveAdress(AdressDTO adressDTO);

    AdressDTO update(AdressDTO adressDTO);

    AdressDTO update(AdressDTO adressDTO, Long id);

    Optional<AdressDTO> findById(Long id);

    Optional<AdressDTO> findBySlug(String slug);

    List<AdressDTO> findAll();

    void deleteById(Long id);
}
