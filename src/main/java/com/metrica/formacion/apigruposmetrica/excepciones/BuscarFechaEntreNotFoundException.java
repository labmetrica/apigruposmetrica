package com.metrica.formacion.apigruposmetrica.excepciones;

import java.time.LocalDate;

import org.springframework.dao.DataAccessException;

public class BuscarFechaEntreNotFoundException extends DataAccessException {

	public BuscarFechaEntreNotFoundException(LocalDate date1, LocalDate date2) {
		super("No hay grupos entre estas horas " + date1 + "y" + date2);
	}

}
