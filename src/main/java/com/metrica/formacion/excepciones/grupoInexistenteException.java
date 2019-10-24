package com.metrica.formacion.excepciones;

import com.metrica.formacion.entity.Grupo;

public class grupoInexistenteException extends RuntimeException{
	private Grupo inexistente;	
	
	public grupoInexistenteException(Grupo falta){
		this.inexistente = falta;
	}
}
