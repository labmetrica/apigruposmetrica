package com.metrica.formacion.apigruposmetrica.excepciones;

import java.time.LocalDate;

import org.springframework.dao.DataAccessException;

public class BuscarModificacionAntesNotFoundException extends DataAccessException {

	public BuscarModificacionAntesNotFoundException(LocalDate localdate) {
		super("No hay hora antes de " + localdate);
	}

}
