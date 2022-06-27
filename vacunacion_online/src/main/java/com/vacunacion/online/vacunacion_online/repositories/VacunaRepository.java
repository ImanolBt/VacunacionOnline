package com.vacunacion.online.vacunacion_online.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacunacion.online.vacunacion_online.models.Vacuna;

@Repository
public interface VacunaRepository extends JpaRepository<Vacuna,Long>{
    
}
