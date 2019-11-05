package com.metrica.formacion.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grupos")

public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "nombre", nullable = false)
	private LocalTime nombre;

	@Column(name = "Huecos_Libres")
	private int huecos;

	@Column(name = "createdAT")
	private LocalDateTime createdAT;

	@Column(name = "ultima_modificacion")
	private LocalDateTime ultima_modificacion;

	public Grupo() {
		ultima_modificacion = LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalTime getNombre() {
		return nombre;
	}

	public void setNombre(LocalTime nombre) {
		this.nombre = nombre;
	}

	public int getHuecos() {
		return huecos;
	}

	public void setHuecos(int huecos) {
		this.huecos = huecos;
	}

	public void setHuecosMas1() {
		if (huecos < 12) {
			huecos++;
		}
	}

	public void setHuecosMenos1() {
		if (huecos > 0) {
			huecos--;
		}
	}

	public LocalDateTime getCreatedAT() {
		return createdAT;
	}

	public void setCreatedAT(LocalDateTime createdAT) {
		this.createdAT = createdAT;
	}

	public LocalDateTime getUltima_modificacion() {
		return ultima_modificacion;
	}

	public void setUltima_modificacion() {
		this.ultima_modificacion = LocalDateTime.now();
	}

	public void setUltima_modificacion(LocalDateTime ultima_modificacion) {
		this.ultima_modificacion = ultima_modificacion;
	}

}
