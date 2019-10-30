package com.metrica.formacion.service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import com.metrica.formacion.entity.Grupo;
import com.metrica.formacion.entity.GrupoDTO;

public interface GrupoInterface {
	
	public List<GrupoDTO> getAll();
	
	public GrupoDTO getById(int id);
	
	public GrupoDTO getByNombre (Time nombre);
	
	public boolean newGrupo (Grupo actualizar);

	public boolean updateGrupo (int id, Grupo actualizar);

	public boolean sacarDeGrupo (int id); 

	public boolean meterEnGrupo (int id);

	public boolean moverDeGrupo (int idOriginal, int idActualizar);
	
	public List<GrupoDTO> getLibres ();
	
	public boolean deleteGrupo (int id);
	
}
