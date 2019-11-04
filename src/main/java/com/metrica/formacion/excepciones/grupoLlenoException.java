package com.metrica.formacion.excepciones;

import com.metrica.formacion.entity.Grupo;

public class grupoLlenoException extends RuntimeException {
	private Grupo lleno;

	public grupoLlenoException(Grupo lleno) {
		this.lleno = lleno;
	}

	public grupoLlenoException() {
	}
}
