package com.digitalacademy.monetab.services;

import com.digitalacademy.monetab.models.FileNote;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface FileNoteService {

    FileNote save(FileNote fileNote);
    FileNote update(FileNote fileNote);
    Optional<FileNote> findById(Long id);
    List<FileNote> findAll();
    void deleteById(Long id);
}
