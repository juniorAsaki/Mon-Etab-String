package com.digitalacademy.monetab.services.Mapping;

import com.digitalacademy.monetab.models.User;
import com.digitalacademy.monetab.services.dto.UserDTO;

public final class UserMapping {

    private UserMapping() {
    }

    public static void partialUpdate(User user, UserDTO userDTO) {
        if (userDTO.getPseudo() != null) {
            user.setPseudo(userDTO.getPseudo());
        }

        if (userDTO.getDisable() != null) {
            user.setDisable(userDTO.getDisable());
        }
    }
}
