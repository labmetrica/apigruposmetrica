package com.metrica.formacion.entity;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Timestamp;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "grupos")

public class Grupo {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getNombre() {
		return nombre;
	}

	public void setNombre(Time nombre) {
		this.nombre = nombre;
	}

	public int getHuecos() {
		return huecos;
	}

	public void setHuecos(int huecos) {
		this.huecos = huecos;
	}

	public Timestamp getCreatedAT() {
		return createdAT;
	}

	public void setCreatedAT(Timestamp createdAT) {
		this.createdAT = createdAT;
	}

	public Timestamp getUltima_modificacion() {
		return ultima_modificacion;
	}

	public void setUltima_modificacion(Timestamp ultima_modificacion) {
		this.ultima_modificacion = ultima_modificacion;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
	
	@Column(name = "nombre", nullable = false)
	private Time nombre;
	
	@Column(name = "Huecos_Libres")
	private int huecos;

    @Column(name = "createdAT")
    private Timestamp createdAT;

    @Column(name = "ultima_modificacion")
    private Timestamp ultima_modificacion;

    	
}
