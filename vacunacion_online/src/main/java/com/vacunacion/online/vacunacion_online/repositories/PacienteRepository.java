package com.vacunacion.online.vacunacion_online.repositories;

 

import com.vacunacion.online.vacunacion_online.models.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    
}
