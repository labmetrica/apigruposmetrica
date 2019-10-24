package Excepciones;

import Entity.Grupo;

public class grupoLlenoException extends RuntimeException{
	private Grupo lleno;	
	
	public grupoLlenoException(Grupo lleno){
		this.lleno = lleno;
	}
	
	public grupoLlenoException(){
	}
}
