package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.SchoolDTO;

import java.util.List;

public interface SchoolService {

    SchoolDTO save(SchoolDTO schoolDTO);

    List<SchoolDTO> findAll();

    SchoolDTO findOne(Long id);

    void delete(Long id);

    SchoolDTO update(SchoolDTO schoolDTO);

    SchoolDTO existingSchool();

    SchoolDTO initSchool(SchoolDTO schoolDTO);

}
