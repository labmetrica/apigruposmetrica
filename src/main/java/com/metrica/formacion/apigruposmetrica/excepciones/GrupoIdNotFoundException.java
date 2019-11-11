package com.metrica.formacion.apigruposmetrica.excepciones;

import org.springframework.dao.DataAccessException;

import com.metrica.formacion.apigruposmetrica.entity.grupos;

public class GrupoIdNotFoundException extends DataAccessException {

	public GrupoIdNotFoundException(grupos grupo) {
		super("Este id" + grupo.getId() + " o horario" + grupo.getNombre() + " ya existe");
	}

}
