package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.models.FileNote;
import com.digitalacademy.monetab.services.dto.FileNoteDTO;

import java.util.List;
import java.util.Optional;


public interface FileNoteService {

    FileNoteDTO save(FileNoteDTO fileNoteDTO);
    FileNoteDTO update(FileNoteDTO fileNoteDTO);
    Optional<FileNoteDTO> findById(Long id);
    List<FileNoteDTO> findAll();
    void deleteById(Long id);
}
