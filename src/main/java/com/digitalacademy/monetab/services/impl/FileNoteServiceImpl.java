package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.models.FileNote;
import com.digitalacademy.monetab.models.Student;
import com.digitalacademy.monetab.repositories.FileNoteRepository;
import com.digitalacademy.monetab.services.FileNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FileNoteServiceImpl implements FileNoteService {

    private final FileNoteRepository fileNoteRepository;
    @Override
    public FileNote save(FileNote fileNote) {
        return fileNoteRepository.save(fileNote);
    }

    @Override
    public FileNote update(FileNote fileNote) {
        Optional<FileNote> optionalFileNote = fileNoteRepository.findById(fileNote.getId_file_note());

        if(optionalFileNote.isPresent()){
            FileNote fileNoteUpdate = optionalFileNote.get();

            fileNoteUpdate.setNote(fileNote.getNote());

            return fileNoteRepository.save(fileNoteUpdate);
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<FileNote> findById(Long id) {
        return fileNoteRepository.findById(id);
    }

    @Override
    public List<FileNote> findAll() {
        return fileNoteRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        fileNoteRepository.deleteById(id);
    }
}
