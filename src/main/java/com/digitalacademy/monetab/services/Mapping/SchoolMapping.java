package com.digitalacademy.monetab.services.Mapping;

import com.digitalacademy.monetab.models.School;
import com.digitalacademy.monetab.services.dto.SchoolDTO;

public final class SchoolMapping {

    private SchoolMapping() {
    }

    public static void partialUpdate(School school, SchoolDTO schoolDTO) {

        if (schoolDTO.getNameSchool() != null) {
            school.setNameSchool(schoolDTO.getNameSchool());
        }

        if (schoolDTO.getUrlLogo() != null) {
            school.setUrlLogo(schoolDTO.getUrlLogo());
        }
    }
}
