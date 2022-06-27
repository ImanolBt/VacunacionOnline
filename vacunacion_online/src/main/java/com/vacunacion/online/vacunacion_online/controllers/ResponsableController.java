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

import com.vacunacion.online.vacunacion_online.dto.NewResponsableDTO;
import com.vacunacion.online.vacunacion_online.dto.ResponsableDTO;
import com.vacunacion.online.vacunacion_online.services.ResponsableService;

@RestController
@RequestMapping("/responsables")
public class ResponsableController {
    
    private final ResponsableService service;
    
    @Autowired
    public ResponsableController(ResponsableService srv) {
        this.service = srv;
    }
    
    @PostMapping()
    public ResponseEntity<ResponsableDTO> create(@Valid @RequestBody NewResponsableDTO responsableDTO) {
        ResponsableDTO result = service.create(responsableDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsableDTO> retrieve( @PathVariable("id") Long id) {
        ResponsableDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping()
    public ResponseEntity<List<ResponsableDTO>> list() {
        List<ResponsableDTO> result = service.list();
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponsableDTO> update(@RequestBody ResponsableDTO responsableDTO, @PathVariable("id") Long id) {
        ResponsableDTO result = service.update(responsableDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Responsable eliminado");
    }
}
