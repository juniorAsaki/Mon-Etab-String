package com.digitalacademy.monetab.services.dto;

import com.digitalacademy.monetab.models.Teacher;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileNoteDTO {

    private Long id_file_note;

    private Double note ;

    private TeacherDTO teacher ;
}
