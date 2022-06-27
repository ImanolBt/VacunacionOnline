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
@Table(name="TBL_RESPONSABLE")
@Getter
@Setter 
public class Responsable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="CEDULA")
    private String cedula;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="DIRECCION")
    private String direccion;
    @Column(name="TELEFONO")
    private String telefono;
    @Column(name="EMAIL")
    private String email;
    @Column(name="OCUPACION")
    private String ocupacion;
    //relaciones

}
