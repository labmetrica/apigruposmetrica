package com.metrica.formacion.apigruposmetrica.excepciones;

import org.springframework.dao.DataAccessException;

import com.metrica.formacion.apigruposmetrica.entity.grupos;

public class BorrarGrupoNotFoundException extends DataAccessException {

	public BorrarGrupoNotFoundException(grupos grupo) {
		super("Este grupo no existe" + grupo.getId());
	}

}
