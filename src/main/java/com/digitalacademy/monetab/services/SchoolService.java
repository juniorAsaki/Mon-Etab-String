package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.models.School;
import com.digitalacademy.monetab.services.dto.SchoolDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface SchoolService {

    SchoolDTO save(SchoolDTO schoolDTO);

    SchoolDTO save(SchoolDTO schoolDTO, MultipartFile file) throws IOException;

    SchoolDTO saveSchool(SchoolDTO schoolDTO);

    List<SchoolDTO> findAll();

    Optional<SchoolDTO> findOne(Long id);

    Optional<SchoolDTO> findBySlug(String slug);

    void delete(Long id);

    SchoolDTO update(SchoolDTO schoolDTO);

    SchoolDTO update(SchoolDTO schoolDTO, Long id);

    SchoolDTO partialUpdate(SchoolDTO schoolDTO, Long id);

    SchoolDTO existingSchool();

    SchoolDTO initSchool(SchoolDTO schoolDTO);

}
