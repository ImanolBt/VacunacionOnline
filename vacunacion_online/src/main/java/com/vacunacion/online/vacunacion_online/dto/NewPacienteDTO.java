package com.vacunacion.online.vacunacion_online.dto;



import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
public class NewPacienteDTO {

    @NotNull(message = "Cedula no encontrada")
    private String cedula;
    @NotNull(message = "Cedula no encontrada")
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String observacion;

}
