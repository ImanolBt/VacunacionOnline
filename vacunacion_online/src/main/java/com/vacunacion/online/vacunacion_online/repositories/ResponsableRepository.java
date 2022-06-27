package com.vacunacion.online.vacunacion_online.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacunacion.online.vacunacion_online.models.Responsable;

@Repository
public interface ResponsableRepository extends JpaRepository <Responsable,Long> {
}
