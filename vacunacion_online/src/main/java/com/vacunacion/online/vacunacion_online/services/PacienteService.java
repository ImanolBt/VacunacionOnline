package com.vacunacion.online.vacunacion_online.services;

import java.util.List;

import com.vacunacion.online.vacunacion_online.dto.NewPacienteDTO;
import com.vacunacion.online.vacunacion_online.dto.PacienteDTO;

public interface PacienteService {
    public PacienteDTO create(NewPacienteDTO pacienteDTO);
    public PacienteDTO retrieve(Long id);
    public PacienteDTO update(PacienteDTO pacienteDTO, Long id);
    public void delete(Long id);
    public List<PacienteDTO>list();
    

}
