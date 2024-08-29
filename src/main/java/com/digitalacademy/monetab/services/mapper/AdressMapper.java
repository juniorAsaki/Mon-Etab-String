package com.digitalacademy.monetab.services.mapper;

import com.digitalacademy.monetab.models.Adress;
import com.digitalacademy.monetab.services.dto.AdressDTO;

public final class AdressMapper {

    private AdressMapper() {}

    public static AdressDTO toAdressDTO(Adress adress) {
        AdressDTO adressDTO = new AdressDTO();
        adressDTO.setId_adress(adress.getId_adress());
        adressDTO.setCity(adress.getCity());
        adressDTO.setCountry(adress.getCountry());
        adressDTO.setStreet(adress.getStreet());

        return adressDTO;
    }

    public static Adress toAdress(AdressDTO adressDTO) {
        Adress adress = new Adress();
        adress.setId_adress(adressDTO.getId_adress());
        adress.setCity(adressDTO.getCity());
        adress.setCountry(adressDTO.getCountry());
        adress.setStreet(adressDTO.getStreet());
        return adress;
    }
}
