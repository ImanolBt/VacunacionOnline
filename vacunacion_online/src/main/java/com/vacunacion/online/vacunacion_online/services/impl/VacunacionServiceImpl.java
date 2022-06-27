package com.vacunacion.online.vacunacion_online.services.impl;



import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunacion.online.vacunacion_online.dto.NewVacunacionDTO;
import com.vacunacion.online.vacunacion_online.dto.VacunacionDTO;
import com.vacunacion.online.vacunacion_online.exceptions.ResourceNotFoundException;
import com.vacunacion.online.vacunacion_online.models.Vacunacion;
import com.vacunacion.online.vacunacion_online.repositories.VacunacionRepository;
import com.vacunacion.online.vacunacion_online.services.VacunacionService;
 


@Service
public class VacunacionServiceImpl implements VacunacionService{
    
    final ModelMapper modelMapper;
    final VacunacionRepository vacunacionRepository;


    @Autowired
    public VacunacionServiceImpl (@Autowired VacunacionRepository repository, ModelMapper mapper){
        this.vacunacionRepository=repository;
        this.modelMapper=mapper;
    }

    @Override
    @Transactional
    public VacunacionDTO create (NewVacunacionDTO vacunacionDTO) {
        Vacunacion vacunacion = modelMapper.map(vacunacionDTO, Vacunacion.class);
        vacunacionRepository.save(vacunacion);        
        return modelMapper.map(vacunacion, VacunacionDTO.class); 
    }

    @Override
    @Transactional(readOnly = true)
    public VacunacionDTO retrieve(Long id) {
        Vacunacion vacunacion = vacunacionRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Carnet not found"));
        return modelMapper.map(vacunacion, VacunacionDTO.class);
    }

    @Override
    @Transactional
    public VacunacionDTO update(VacunacionDTO vacunacionDTO, Long id) {
        Vacunacion vacunacion = vacunacionRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Carnet not found"));
        
        vacunacion.setId(id);
        vacunacion = modelMapper.map(vacunacionDTO, Vacunacion.class);
        vacunacionRepository.save(vacunacion);       
        return modelMapper.map(vacunacion, VacunacionDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Vacunacion vacunacion = vacunacionRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Carnet not found"));        
        vacunacionRepository.deleteById(vacunacion.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<VacunacionDTO> list() {
        List<Vacunacion> vacunaciones = vacunacionRepository.findAll();
        return vacunaciones.stream().map(vacunacion -> modelMapper.map(vacunacion, VacunacionDTO.class))
            .collect(Collectors.toList());        
    }
    

}
