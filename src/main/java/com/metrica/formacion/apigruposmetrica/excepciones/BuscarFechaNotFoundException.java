package com.metrica.formacion.apigruposmetrica.excepciones;

import java.time.LocalDate;

import org.springframework.dao.DataAccessException;

public class BuscarFechaNotFoundException extends DataAccessException {

	public BuscarFechaNotFoundException(LocalDate localdate) {
		super("Esta hora no existe " + localdate);
	}

}
