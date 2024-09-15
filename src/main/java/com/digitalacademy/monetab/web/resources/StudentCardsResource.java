package com.digitalacademy.monetab.web.resources;


import com.digitalacademy.monetab.services.StudentCardsService;
import com.digitalacademy.monetab.services.dto.StudentCardsDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@Slf4j
@RequiredArgsConstructor
public class StudentCardsResource {
    private final StudentCardsService studentCardsService;

    @PostMapping
    public ResponseEntity<StudentCardsDTO> saveCard(@RequestBody StudentCardsDTO studentCardsDTO) {
        log.debug("REST request to save StudentCards : {}", studentCardsDTO);

        return new ResponseEntity<>(studentCardsService.saveStudentCards(studentCardsDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<StudentCardsDTO> getAllCards() {
        log.debug("REST request to get all StudentCards");

        return studentCardsService.findAll();
    }

    @GetMapping("/{id}")
    public StudentCardsDTO getCardById(@PathVariable Long id) {
        log.debug("REST request to get StudentCards : {}", id);
        return studentCardsService.findById(id);
    }

    @GetMapping("/slug/{slug}")
    public StudentCardsDTO getCardBySlug(@PathVariable String slug) {
        log.debug("REST request to get StudentCards by slug : {}", slug);
        return studentCardsService.findBySlug(slug).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteCardById(@PathVariable Long id) {
        log.debug("REST request to delete StudentCards : {}", id);
        studentCardsService.delete(id);
    }

    @PutMapping("/{id}")
    public StudentCardsDTO updateCard(@PathVariable Long id, @RequestBody StudentCardsDTO studentCardsDTO) {
        log.debug("REST request to update StudentCards : {} : {}", studentCardsDTO, id);

        return studentCardsService.update(studentCardsDTO, id);
    }
}
