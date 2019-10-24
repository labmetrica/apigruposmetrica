package com.metrica.formacion.dao;

import java.util.Date;
import java.util.List;

import com.metrica.formacion.entity.Grupo;

public interface GrupoInterface {
	
	public List<Grupo> getAll();
	
	public Grupo getById(long id);
	
	public Grupo getByNombre (String nombre);

	public Grupo getByHorario (Date horario);

	public boolean updateGrupo (long id, Grupo actualizar);
	
	public boolean sacarDeGrupo (long id); 
	
	public boolean meterEnGrupo (long id);
	
	public boolean moverDeGrupo (long IDoriginal, Grupo actualizar);
	
	public List<Grupo> getLibres ();
	
	public boolean deleteGrupo (long id);
	
}
