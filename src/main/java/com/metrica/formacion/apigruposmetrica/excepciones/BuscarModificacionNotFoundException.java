package com.metrica.formacion.apigruposmetrica.excepciones;

import java.time.LocalDate;

import org.springframework.dao.DataAccessException;

public class BuscarModificacionNotFoundException extends DataAccessException {

	public BuscarModificacionNotFoundException(LocalDate localdate) {
		super("Esta modificacion no existe " + localdate);
	}

}
