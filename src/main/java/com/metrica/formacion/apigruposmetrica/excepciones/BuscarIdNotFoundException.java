package com.metrica.formacion.apigruposmetrica.excepciones;

import org.springframework.dao.DataAccessException;

public class BuscarIdNotFoundException extends DataAccessException {

	public BuscarIdNotFoundException(final long id) {
		super("Este id no existe " + id);
	}

}
