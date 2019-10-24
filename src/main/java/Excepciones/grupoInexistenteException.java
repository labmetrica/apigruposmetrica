package Excepciones;

import Entity.Grupo;

public class grupoInexistenteException extends RuntimeException{
	private Grupo inexistente;	
	
	public grupoInexistenteException(Grupo falta){
		this.inexistente = falta;
	}
}
