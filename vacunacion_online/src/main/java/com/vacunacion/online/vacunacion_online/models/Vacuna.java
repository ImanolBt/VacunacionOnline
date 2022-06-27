package com.vacunacion.online.vacunacion_online.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_VACUNA")
@Getter
@Setter

public class Vacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="LOTE")
    private String lote;
    @Column(name="TIPO")
    private String tipo;
    @Column(name="NOMBRE")
    private String nombre;

    //relacion
}
