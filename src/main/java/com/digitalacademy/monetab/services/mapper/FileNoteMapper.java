package com.digitalacademy.monetab.services.mapper;

import com.digitalacademy.monetab.models.FileNote;
import com.digitalacademy.monetab.services.dto.FileNoteDTO;

public final class FileNoteMapper {

    private FileNoteMapper() {}

    public static FileNoteDTO toFileNoteDTO(FileNote fileNote) {

        FileNoteDTO fileNoteDTO = new FileNoteDTO();
        fileNoteDTO.setId_file_note(fileNote.getId_file_note());
        fileNoteDTO.setNote(fileNote.getNote());
        fileNoteDTO.setTeacher(fileNote.getTeacher());
        return fileNoteDTO;
    }

    public static FileNote toFileNote(FileNoteDTO fileNoteDTO) {

        FileNote fileNote = new FileNote();
        fileNote.setId_file_note(fileNoteDTO.getId_file_note());
        fileNote.setNote(fileNoteDTO.getNote());
        fileNote.setTeacher(fileNoteDTO.getTeacher());
        return fileNote;
    }
}
