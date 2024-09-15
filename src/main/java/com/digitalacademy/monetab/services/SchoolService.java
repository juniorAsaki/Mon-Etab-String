package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.services.dto.SchoolDTO;

import java.util.List;
import java.util.Optional;

public interface SchoolService {

    SchoolDTO save(SchoolDTO schoolDTO);

    SchoolDTO saveSchool(SchoolDTO schoolDTO);

    List<SchoolDTO> findAll();

    Optional<SchoolDTO> findOne(Long id);

    Optional<SchoolDTO> findBySlug(String slug);

    void delete(Long id);

    SchoolDTO update(SchoolDTO schoolDTO);

    SchoolDTO update(SchoolDTO schoolDTO, Long id);

    SchoolDTO existingSchool();

    SchoolDTO initSchool(SchoolDTO schoolDTO);

}
