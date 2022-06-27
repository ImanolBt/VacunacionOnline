package com.vacunacion.online.vacunacion_online.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewVacunacionDTO {
    
    private Date fecha_vacunacion;
    @NotNull(message="Lugar no encontrado")
    private String lugar;
    private String dosis;

}
