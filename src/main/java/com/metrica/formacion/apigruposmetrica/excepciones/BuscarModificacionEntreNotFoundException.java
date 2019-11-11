package com.metrica.formacion.apigruposmetrica.excepciones;

import java.time.LocalDate;

import org.springframework.dao.DataAccessException;

public class BuscarModificacionEntreNotFoundException extends DataAccessException {

	public BuscarModificacionEntreNotFoundException(LocalDate date1, LocalDate date2) {
		super("No hay horario entre " + date1 + "y" + date2);
	}

}
