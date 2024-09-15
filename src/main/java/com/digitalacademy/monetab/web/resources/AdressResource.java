package com.digitalacademy.monetab.web.resources;


import com.digitalacademy.monetab.services.AdressService;
import com.digitalacademy.monetab.services.dto.AdressDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/adress")
@Slf4j
@RequiredArgsConstructor
public class AdressResource {

    private final AdressService adressService;

    @PostMapping
    public ResponseEntity<AdressDTO> saveAdress(AdressDTO adressDTO) {
        log.debug("REST request to save Adress: {}", adressDTO);
        return new ResponseEntity<>(adressService.saveAdress(adressDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public AdressDTO update(AdressDTO adressDTO, @PathVariable Long id) {
        log.debug("REST request to update Adress : {}", adressDTO);
        return adressService.update(adressDTO, id);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        log.debug("REST request to get all Adresses");

        List<AdressDTO> adressDTOS = adressService.findAll();
        if (adressDTOS.isEmpty()) {
            return new ResponseEntity<>("Aucune adress trouver !", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(adressDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<AdressDTO> getOneById(@PathVariable Long id) {
        log.debug("REST request to get Adress : {}", id);

        return adressService.findById(id);
    }

    @GetMapping("/slug/{slug}")
    public Optional<AdressDTO> getOneBySlug(@PathVariable String slug) {
        log.debug("REST request to get Adress : {}", slug);

        return adressService.findBySlug(slug);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.debug("REST request to delete Adress : {}", id);

        Optional<AdressDTO> adressDTO = adressService.findById(id);
        adressDTO.ifPresent(dto -> adressService.deleteById(dto.getId_adress()));
    }
}
