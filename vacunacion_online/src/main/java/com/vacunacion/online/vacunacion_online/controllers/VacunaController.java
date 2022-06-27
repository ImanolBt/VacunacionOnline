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

import com.vacunacion.online.vacunacion_online.dto.NewVacunaDTO;
import com.vacunacion.online.vacunacion_online.dto.VacunaDTO;
import com.vacunacion.online.vacunacion_online.services.VacunaService;

@RestController 
@RequestMapping("/vacunas")
public class VacunaController {
    
    private final VacunaService service;
    @Autowired
    public VacunaController(VacunaService srv) {
        this.service = srv;
    }

    @PostMapping()
    public ResponseEntity<VacunaDTO> create(@Valid @RequestBody NewVacunaDTO vacunaDTO) {
        VacunaDTO result = service.create(vacunaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacunaDTO> retrieve( @PathVariable("id") Long id) {
        VacunaDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping()
    public ResponseEntity<List<VacunaDTO>> list() {
        List<VacunaDTO> result = service.list();
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacunaDTO> update(@RequestBody VacunaDTO vacunaDTO, @PathVariable("id") Long id) {
        VacunaDTO result = service.update(vacunaDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Vacuna eliminada");
    }
    
}
