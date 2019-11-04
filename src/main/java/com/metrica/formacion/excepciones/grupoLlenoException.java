package com.metrica.formacion.excepciones;

import com.metrica.formacion.entity.grupos;

public class grupoLlenoException extends RuntimeException{
	private grupos lleno;
	
	public grupoLlenoException(grupos lleno){
		this.lleno = lleno;
	}
	
	public grupoLlenoException(){
	}
}
