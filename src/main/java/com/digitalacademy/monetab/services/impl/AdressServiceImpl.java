package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.models.Adress;
import com.digitalacademy.monetab.models.FileNote;
import com.digitalacademy.monetab.repositories.AdressRepository;
import com.digitalacademy.monetab.services.AdressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdressServiceImpl implements AdressService {

    private final AdressRepository adressRepository;
    @Override
    public Adress save(Adress adress) {
        return adressRepository.save(adress);
    }

    @Override
    public Adress update(Adress adress) {
        Optional<Adress> optionalAdress = adressRepository.findById(adress.getId_adress());

        if(optionalAdress.isPresent()){
            Adress adressUpdate = optionalAdress.get();

            adressUpdate.setCountry(adress.getCountry());
            adressUpdate.setCity(adress.getCity());
            adressUpdate.setStreet(adress.getStreet());

            return adressRepository.save(adressUpdate);
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<Adress> findById(Long id) {
        return adressRepository.findById(id);
    }

    @Override
    public List<Adress> findAll() {
        return adressRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        adressRepository.deleteById(id);
    }
}
