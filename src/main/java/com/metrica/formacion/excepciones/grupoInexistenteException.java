package com.metrica.formacion.excepciones;

import com.metrica.formacion.entity.grupos;

public class grupoInexistenteException extends RuntimeException{
	private grupos inexistente;
	
	public grupoInexistenteException(grupos falta){
		this.inexistente = falta;
	}
}
