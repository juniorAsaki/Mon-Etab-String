package com.digitalacademy.monetab.services.mapper.impl;

import com.digitalacademy.monetab.models.FileNote;
import com.digitalacademy.monetab.services.dto.FileNoteDTO;
import com.digitalacademy.monetab.services.mapper.FileNoteMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class FileNoteMapperImpl implements FileNoteMapper {

    private final ModelMapper modelMapper;

    @Override
    public FileNoteDTO ToDto(FileNote entity) {
        return modelMapper.map(entity, FileNoteDTO.class);
    }

    @Override
    public FileNote DtoToEntity(FileNoteDTO dto) {
        return modelMapper.map(dto, FileNote.class);
    }
}
