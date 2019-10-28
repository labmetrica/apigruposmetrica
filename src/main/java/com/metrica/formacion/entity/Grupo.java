package com.metrica.formacion.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "grupos_de_comida")
@Data
public class Grupo {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdGrupo")
	private long id ;
	
	@Column(name = "Nombre", nullable = false)
	private LocalTime nombre;
	
	@Column(name = "Huecos_Libres")
	private int huecos;

    @Column(name = "createdAT")
    private LocalDateTime createdAT;

    @Column(name = "ultima_modificacion")
    private LocalDateTime ultima_modificacion;

    	
}
