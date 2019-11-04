package com.metrica.formacion.service;

import java.time.LocalTime;
import java.util.List;

import com.metrica.formacion.entity.Grupo;

public interface GrupoInterface {

	public List<Grupo> getAll();

	public Grupo getById(int id);

	public Grupo getByNombre(LocalTime nombre);

	public boolean newGrupo(Grupo actualizar);

	public boolean updateGrupo(int id, Grupo actualizar);

	public boolean sacarDeGrupo(int id);

	public boolean meterEnGrupo(int id);

	public boolean moverDeGrupo(int idOriginal, int idActualizar);

	public boolean deleteGrupo(int id);

	public boolean deleteAllGrupos();

}
