package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.SchoolDTO;

import java.util.Set;

public interface SchoolService {

    SchoolDTO save(SchoolDTO schoolDTO);
    Set<SchoolDTO> findAll();
    SchoolDTO findOne(Long id);
    void delete(Long id);
    SchoolDTO update(SchoolDTO schoolDTO);
}
