package com.metrica.formacion.entity;

import java.util.Date;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "Grupos_de_Comida")
@Data
public class Grupo {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdGrupo")
	private long  id ;	
	
	@Column(name = "Nombre", nullable = false)
	private Date nombre;
	
	@Column(name = "Huecos_Libres")
	private int huecos;
	
	@Column(name = "Horario")
	private Date horario;
}
