package com.vacunacion.online.vacunacion_online.services;

import java.util.List;

import com.vacunacion.online.vacunacion_online.dto.NewVacunaDTO;
import com.vacunacion.online.vacunacion_online.dto.VacunaDTO;

public interface VacunaService {
    public VacunaDTO create (NewVacunaDTO vacunaDTO);
    public VacunaDTO retrieve(Long id);
    public VacunaDTO update(VacunaDTO vacunaDTO,Long id);
    public void delete(Long id);
    public List<VacunaDTO>list();
    
}
