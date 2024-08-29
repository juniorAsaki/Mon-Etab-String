package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.models.FileNote;
import com.digitalacademy.monetab.repositories.FileNoteRepository;
import com.digitalacademy.monetab.services.FileNoteService;
import com.digitalacademy.monetab.services.dto.FileNoteDTO;
import com.digitalacademy.monetab.services.mapper.FileNoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FileNoteServiceImpl implements FileNoteService {

    private final FileNoteRepository fileNoteRepository;

    @Override
    public FileNoteDTO save(FileNoteDTO fileNoteDTO) {

        FileNote fileNote = FileNoteMapper.toFileNote(fileNoteDTO);
        return FileNoteMapper.toFileNoteDTO(fileNoteRepository.save(fileNote));
    }

    @Override
    public FileNoteDTO update(FileNoteDTO fileNoteDTO) {

        FileNote fileNote = FileNoteMapper.toFileNote(fileNoteDTO);
        return FileNoteMapper.toFileNoteDTO(fileNoteRepository.save(fileNote));
    }

    @Override
    public Optional<FileNoteDTO> findById(Long id) {
        return fileNoteRepository.findById(id).map(fileNote -> FileNoteMapper.toFileNoteDTO(fileNote));
    }

    @Override
    public List<FileNoteDTO> findAll() {
        return fileNoteRepository.findAll().stream().map(fileNote -> FileNoteMapper.toFileNoteDTO(fileNote)).toList();
    }

    @Override
    public void deleteById(Long id) {
        fileNoteRepository.deleteById(id);
    }
}
