package com.metrica.formacion.service;

import java.util.Date;
import java.util.List;

import com.metrica.formacion.entity.Grupo;

public interface GrupoInterface {
	
	public List<Grupo> getAll();
	
	public Grupo getById(long id);
	
	public Grupo getByNombre (Date nombre);
	
	public boolean newGrupo (Grupo actualizar);

	public boolean updateGrupo (long id, Grupo actualizar);

	public boolean sacarDeGrupo (long id); 

	public boolean meterEnGrupo (long id);

	public boolean moverDeGrupo (long idOriginal, long idActualizar);
	
	public List<Grupo> getLibres ();
	
	public boolean deleteGrupo (long id);
	
}
