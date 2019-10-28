package com.metrica.formacion.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

@Data
public class GrupoDTO {
	private int  id ;	
	private LocalTime nombre;
	private int huecos;
    private LocalDateTime createdAT;
    private LocalDateTime ultima_modificacion;

}
