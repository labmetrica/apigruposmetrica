package com.metrica.formacion.apigruposmetrica.excepciones;

import java.time.LocalDate;

import org.springframework.dao.DataAccessException;

public class BuscarFechaAntesNotFoundException extends DataAccessException {

	public BuscarFechaAntesNotFoundException(LocalDate localdate) {
		super("No hay fecha antes que esta " + localdate);
	}

}
