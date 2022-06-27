package com.vacunacion.online.vacunacion_online.services;

import java.util.List;

import com.vacunacion.online.vacunacion_online.dto.NewResponsableDTO;
import com.vacunacion.online.vacunacion_online.dto.ResponsableDTO;

public interface ResponsableService {
    public ResponsableDTO create(NewResponsableDTO responsableDTO);
    public ResponsableDTO retrieve (Long id);
    public ResponsableDTO update(ResponsableDTO responsableDTO,Long id);
    public void delete(Long id);
    public List<ResponsableDTO>list();
    
} 
