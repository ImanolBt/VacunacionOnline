package com.vacunacion.online.vacunacion_online.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewVacunaDTO {
    
    @NotNull(message="Lote no encontrado")
    private String lote;
    private String tipo;
    private String nombre;
}
