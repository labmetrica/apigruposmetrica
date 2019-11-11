package com.metrica.formacion.apigruposmetrica.excepciones;

public class ListarUsuariosNotFoundException extends RuntimeException {
	public ListarUsuariosNotFoundException() {
		super("No hay grupos creados");
	}
}
