package com.metrica.formacion.apigruposmetrica.excepciones;

import java.time.LocalTime;

import org.springframework.dao.DataAccessException;

public class BuscarNombreNotFoundException extends DataAccessException {

	public BuscarNombreNotFoundException(LocalTime LocalTime) {
		super("Este horario no esta disponible " + LocalTime);
	}

}
