package com.metrica.formacion.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.metrica.formacion.entity.grupos;

public interface GrupoService {
	
	//Busquedas
	
	List<grupos> getAll();
	
	grupos getById(int id);

	//Cambios en BDD 

	grupos guardarGrupo(grupos nuevo);

	void borrarGrupo(int id);

	void borrarGrupo(grupos grupo);

	void borrarTodosGrupos();
	/*BuscarPorFechas*/

	//Nombre
	
	grupos getByNombre(LocalTime localTime);
	
	//Ultima Modificacion

	List<grupos> buscarPorUltimaModificacion(LocalDate localDate);

	List<grupos> buscarPorUltimaModificacionBefore(LocalDate localDate);

	List<grupos> buscarPorUltimaModificacionBeetwen(LocalDate date1, LocalDate date2);

	//CreatedAT

	List<grupos> buscarPorCreatedAT(LocalDate localDate);

	List<grupos> buscarPorCreatedATBefore(LocalDate localDate);

	List<grupos> buscarPorCreatedATBeetwen(LocalDate date1, LocalDate date2);

}
