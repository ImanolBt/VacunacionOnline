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

import com.vacunacion.online.vacunacion_online.dto.NewPacienteDTO;
import com.vacunacion.online.vacunacion_online.dto.PacienteDTO;
import com.vacunacion.online.vacunacion_online.services.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    
    private final PacienteService service;
    
    @Autowired
    public PacienteController(PacienteService srv) {
        this.service = srv;
    }

    @PostMapping()
    public ResponseEntity<PacienteDTO> create(@Valid @RequestBody NewPacienteDTO pacienteDTO) {
        PacienteDTO result = service.create(pacienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> retrieve( @PathVariable("id") Long id) {
        PacienteDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping()
    public ResponseEntity<List<PacienteDTO>> list() {
        List<PacienteDTO> result = service.list();
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> update(@RequestBody PacienteDTO pacienteDTO, @PathVariable("id") Long id) {
        PacienteDTO result = service.update(pacienteDTO, id);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Paciente eliminado");
    }
}
