package com.metrica.formacion.service;

import java.util.Date;
import java.util.List;

import com.metrica.formacion.entity.Grupo;

public interface GrupoInterface {
	
	// ITS ALIIIIVE
	public List<Grupo> getAll();
	
	// ITS ALIIIIVE
	public Grupo getById(long id);
	
	public Date getByNombre (Date nombre);

	public boolean updateGrupo (long id, Grupo actualizar);
	
	public boolean sacarDeGrupo (long id); 
	
	public boolean meterEnGrupo (long id);
	
	public boolean moverDeGrupo (long idOriginal, long idActualizar);
	
	// ITS ALIIIIVE
	public List<Grupo> getLibres ();
	
	// ITS ALIIIIVE
	public boolean deleteGrupo (long id);
	
}
