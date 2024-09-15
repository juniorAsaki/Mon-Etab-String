package com.digitalacademy.monetab.services.Mapping;

import com.digitalacademy.monetab.models.Absence;
import com.digitalacademy.monetab.services.dto.AbsenceDTO;

public final class AbsenceMapping {

    private AbsenceMapping() {
    }

    public static void partialUpdate(Absence absence, AbsenceDTO absenceDTO) {
        if (absenceDTO.getNumberAbsence() != null) {
            absence.setNumberAbsence(absenceDTO.getNumberAbsence());
        }

        if (absenceDTO.getDateAbsence() != null) {
            absence.setDateAbsence(absenceDTO.getDateAbsence());
        }
        
    }
}
