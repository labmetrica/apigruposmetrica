package com.metrica.formacion.apigruposmetrica.excepciones;

import org.springframework.dao.DataAccessException;

public class BorrarIdNotFoundException extends DataAccessException {

	public BorrarIdNotFoundException(final long id) {
		super("Este id no existe" + id);
	}

}
