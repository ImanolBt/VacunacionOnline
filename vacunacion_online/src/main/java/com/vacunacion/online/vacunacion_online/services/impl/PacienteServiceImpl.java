package com.vacunacion.online.vacunacion_online.services.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunacion.online.vacunacion_online.dto.NewPacienteDTO;
import com.vacunacion.online.vacunacion_online.dto.PacienteDTO;
import com.vacunacion.online.vacunacion_online.exceptions.ResourceNotFoundException;
import com.vacunacion.online.vacunacion_online.models.Paciente;
 
import com.vacunacion.online.vacunacion_online.repositories.PacienteRepository;
import com.vacunacion.online.vacunacion_online.services.PacienteService;




@Service
public class PacienteServiceImpl  implements PacienteService{


    final ModelMapper modelMapper;
    final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteServiceImpl(@Autowired PacienteRepository repository, ModelMapper mapper){
        this.pacienteRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public PacienteDTO create(NewPacienteDTO pacienteDTO) {
        Paciente paciente = modelMapper.map(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);        
        /*return modelMapper.map(paciente, PacienteDTO.class); */
        return modelMapper.map(paciente,PacienteDTO.class);

    }

    @Override
    @Transactional(readOnly = true)
    public PacienteDTO retrieve(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Paciente no Encontrado"));
        return modelMapper.map(paciente, PacienteDTO.class);
    }

    @Override
    @Transactional
    public PacienteDTO update(PacienteDTO pacienteDTO, Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Paciente not found"));
        
        paciente.setId(id);
        paciente = modelMapper.map(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);       

        return modelMapper.map(paciente, PacienteDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Paciente no encontrado"));        
        pacienteRepository.deleteById(paciente.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<PacienteDTO> list() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream().map(paciente -> modelMapper.map(paciente, PacienteDTO.class))
            .collect(Collectors.toList());        
    }


}
