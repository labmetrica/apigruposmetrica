package com.metrica.formacion.apigruposmetrica.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "grupos")
public class grupos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "nombre", nullable = false)
	private LocalTime nombre;

	@Column(name = "Huecos")
	private int huecos = 12;

	@Column(name = "createdAT")
	private LocalDateTime createdAT;

	@Column(name = "ultima_modificacion")
	private LocalDateTime ultimaModificacion;

	public grupos() {

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

	public void setHuecosmas1() {

		if (huecos < 12) {
			huecos++;
		}
	}

	public void setHuecosmenos1() {

		if (huecos > 0) {
			huecos--;
		}
	}

	public LocalDateTime getCreatedAT() {
		return createdAT;
	}

	@PrePersist
	public void setCreatedAT() {

		this.createdAT = LocalDateTime.now();
	}

	public LocalDateTime getUltimaModificacion() {
		return ultimaModificacion;
	}

	@PreUpdate
	public void setUltimaModificacion() {
		this.ultimaModificacion = LocalDateTime.now();
	}
}
