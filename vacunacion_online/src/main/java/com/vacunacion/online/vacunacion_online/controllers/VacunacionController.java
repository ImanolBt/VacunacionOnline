package com.vacunacion.online.vacunacion_online.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacunacion.online.vacunacion_online.dto.NewVacunacionDTO;
import com.vacunacion.online.vacunacion_online.dto.VacunacionDTO;
import com.vacunacion.online.vacunacion_online.services.VacunacionService;

@RestController
@RequestMapping("/vacunacion")
public class VacunacionController {
    
    private final VacunacionService service;

    @Autowired
    public VacunacionController(VacunacionService srv) {
        this.service = srv;
    }

    @PostMapping()
    public ResponseEntity<VacunacionDTO> create(@Valid @RequestBody NewVacunacionDTO vacunacionDTO) {
        VacunacionDTO result = service.create(vacunacionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<VacunacionDTO> retrieve(@PathVariable("id") Long id) {
        VacunacionDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping()
    public ResponseEntity<List<VacunacionDTO>> list() {
        List<VacunacionDTO> result = service.list();
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacunacionDTO> update(@RequestBody VacunacionDTO vacunacionDTO, @PathVariable("id") Long id) {
        VacunacionDTO result = service.update(vacunacionDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Vacunacion eliminada");
    }
}
