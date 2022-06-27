package com.vacunacion.online.vacunacion_online.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewResponsableDTO {
    @NotNull(message="Cedula no encontrada")
    private String cedula;
    @NotNull(message="nombre no encontrado")
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String ocupacion;
}
