package com.metrica.formacion.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

public class GrupoDTO {
	private int  id ;	
	private LocalTime nombre;
	private int huecos;
    private LocalDateTime createdAT;
    private LocalDateTime ultima_modificacion;
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
	public LocalDateTime getCreatedAT() {
		return createdAT;
	}
	public void setCreatedAT(LocalDateTime createdAT) {
		this.createdAT = createdAT;
	}
	public LocalDateTime getUltima_modificacion() {
		return ultima_modificacion;
	}
	public void setUltima_modificacion(LocalDateTime ultima_modificacion) {
		this.ultima_modificacion = ultima_modificacion;
	}

}
