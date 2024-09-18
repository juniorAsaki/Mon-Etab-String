package com.digitalacademy.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class FileStudentDTO extends StudentDTO {
    private MultipartFile file;
}
