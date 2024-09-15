package com.digitalacademy.monetab.services.impl;

import com.digitalacademy.monetab.models.Adress;
import com.digitalacademy.monetab.repositories.AdressRepository;
import com.digitalacademy.monetab.services.AdressService;
import com.digitalacademy.monetab.services.dto.AdressDTO;
import com.digitalacademy.monetab.services.mapper.AdressMapper;
import com.digitalacademy.monetab.utils.SlugGifyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdressServiceImpl implements AdressService {

    private final AdressRepository adressRepository;
    private final AdressMapper adressMapper;

    @Override
    public AdressDTO save(AdressDTO adressDTO) {
        Adress adress = adressMapper.DtoToEntity(adressDTO);
        return adressMapper.ToDto(adressRepository.save(adress));
    }

    @Override
    public AdressDTO saveAdress(AdressDTO adressDTO) {
        final String SLUG = SlugGifyUtils.generateSlug(adressDTO.getCountry());
        adressDTO.setSlug(SLUG);
        return save(adressDTO);
    }

    @Override
    public AdressDTO update(AdressDTO adressDTO) {

        return findById(adressDTO.getId_adress()).map(existingAdress -> {
            existingAdress.setCountry(adressDTO.getCountry());
            existingAdress.setCity(adressDTO.getCity());
            return save(existingAdress);
        }).orElseThrow(() -> new RuntimeException("Adress not found"));
    }

    @Override
    public AdressDTO update(AdressDTO adressDTO, Long id) {
        adressDTO.setId_adress(id);
        return update(adressDTO);
    }

    @Override
    public Optional<AdressDTO> findById(Long id) {
        return adressRepository.findById(id).map(adress -> {
            return adressMapper.ToDto(adress);
        });
    }

    @Override
    public Optional<AdressDTO> findBySlug(String slug) {
        return adressRepository.findBySlug(slug).map(adressMapper::ToDto);
    }

    @Override
    public List<AdressDTO> findAll() {

        return adressRepository.findAll().stream().map(adress -> {
            return adressMapper.ToDto(adress);
        }).toList();
    }

    @Override
    public void deleteById(Long id) {
        adressRepository.deleteById(id);
    }
}
