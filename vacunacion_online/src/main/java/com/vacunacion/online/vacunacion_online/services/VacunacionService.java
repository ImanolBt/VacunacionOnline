package com.vacunacion.online.vacunacion_online.services;

import java.util.List;

import com.vacunacion.online.vacunacion_online.dto.NewVacunacionDTO;
import com.vacunacion.online.vacunacion_online.dto.VacunacionDTO;

public interface VacunacionService {
    public VacunacionDTO create (NewVacunacionDTO vacunacionDTO);
    public VacunacionDTO retrieve(Long id);
    public VacunacionDTO update(VacunacionDTO vacunacionDTO,Long id);
    public void delete(Long id);
    public List<VacunacionDTO>list();
}


