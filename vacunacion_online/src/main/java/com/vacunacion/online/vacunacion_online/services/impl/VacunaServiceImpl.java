package com.vacunacion.online.vacunacion_online.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunacion.online.vacunacion_online.dto.NewVacunaDTO;
import com.vacunacion.online.vacunacion_online.dto.VacunaDTO;
import com.vacunacion.online.vacunacion_online.exceptions.ResourceNotFoundException;
import com.vacunacion.online.vacunacion_online.models.Vacuna;
import com.vacunacion.online.vacunacion_online.repositories.VacunaRepository;
import com.vacunacion.online.vacunacion_online.services.VacunaService;

@Service
public class VacunaServiceImpl implements VacunaService {

    final ModelMapper modelMapper;
    final VacunaRepository vacunaRepository;

    @Autowired
    public VacunaServiceImpl (@Autowired VacunaRepository repository, ModelMapper mapper){
        this.vacunaRepository=repository;
        this.modelMapper=mapper;
    }

    @Override
    @Transactional
    public VacunaDTO create(NewVacunaDTO vacunaDTO){
        Vacuna vacuna= modelMapper.map(vacunaDTO,Vacuna .class);
        vacunaRepository.save(vacuna);
        return modelMapper.map(vacuna, VacunaDTO.class);
    }


    @Override
    @Transactional(readOnly = true)
    public VacunaDTO retrieve(Long id) {
        Vacuna vacuna = vacunaRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Vacuna no encontrado"));
        return modelMapper.map(vacuna, VacunaDTO.class);
    }

    @Override
    @Transactional
    public VacunaDTO update(VacunaDTO vacunaDTO, Long id) {
        Vacuna vacuna = vacunaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Vacuna no encontrado"));
        
        vacuna.setId(id);
        vacuna= modelMapper.map(vacunaDTO, Vacuna.class);
        vacunaRepository.save(vacuna);       
        return modelMapper.map(vacuna, VacunaDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Vacuna vacuna =vacunaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Vacuna no encontrado"));        
        vacunaRepository.deleteById(vacuna.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<VacunaDTO> list() {
        List<Vacuna> vacunas = vacunaRepository.findAll();
        return vacunas.stream().map(vacuna -> modelMapper.map(vacuna, VacunaDTO.class))
            .collect(Collectors.toList());        
    }


}
