package com.vacunacion.online.vacunacion_online.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vacunacion.online.vacunacion_online.dto.NewResponsableDTO;
import com.vacunacion.online.vacunacion_online.dto.ResponsableDTO;
import com.vacunacion.online.vacunacion_online.exceptions.ResourceNotFoundException;
import com.vacunacion.online.vacunacion_online.models.Responsable;
import com.vacunacion.online.vacunacion_online.repositories.ResponsableRepository;
import com.vacunacion.online.vacunacion_online.services.ResponsableService;

@Service
public class ResponsableServiceImpl implements ResponsableService{
    
    final ModelMapper modelMapper;
    final ResponsableRepository responsableRepository;

    @Autowired
    public ResponsableServiceImpl (@Autowired ResponsableRepository repository, ModelMapper mapper){
        this.responsableRepository=repository;
        this.modelMapper=mapper;
    }

    @Override
    @Transactional
    public ResponsableDTO create(NewResponsableDTO responsableDTO){
        Responsable responsable= modelMapper.map(responsableDTO,Responsable .class);
        responsableRepository.save(responsable);
        return modelMapper.map(responsable, ResponsableDTO.class);
    }


    @Override
    @Transactional(readOnly = true)
    public ResponsableDTO retrieve(Long id) {
        Responsable responsable = responsableRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Responsable no encontrado"));
        return modelMapper.map(responsable, ResponsableDTO.class);
    }

    @Override
    @Transactional
    public ResponsableDTO update(ResponsableDTO responsableDTO, Long id) {
        Responsable responsable = responsableRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Responsable no encontrado"));
        
        responsable.setId(id);
        responsable= modelMapper.map(responsableDTO, Responsable.class);
        responsableRepository.save(responsable);       

        return modelMapper.map(responsable, ResponsableDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Responsable responsable = responsableRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Responsable no encontrado"));        
        responsableRepository.deleteById(responsable.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResponsableDTO> list() {
        List<Responsable> responsables = responsableRepository.findAll();
        return responsables.stream().map(responsable -> modelMapper.map(responsable, ResponsableDTO.class))
            .collect(Collectors.toList());        
    }


}
