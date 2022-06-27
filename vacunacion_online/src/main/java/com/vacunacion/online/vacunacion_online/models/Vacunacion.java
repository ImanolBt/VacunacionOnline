package com.vacunacion.online.vacunacion_online.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TBL_VACUNACION")
@Getter
@Setter

public class Vacunacion {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="FECHA_VACUNACION")
    private Date fecha_vacunacion;
    @Column(name="LUGAR")
    private String lugar;
    @Column(name="DOSIS")
    private String dosis;

    //relacion
}
