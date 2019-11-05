package com.metrica.formacion.service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.metrica.formacion.entity.grupos;
import jdk.vm.ci.meta.Local;

public interface GrupoInterface {
	
	List<grupos> getAll();
	
	grupos getById(int id);

	grupos getByNombre(LocalTime localTime);

	grupos guardarGrupo(grupos grupo);

	void borrarGrupo(int id);

	void borrarGrupo(grupos grupo);

	/*BuscarPorFechas*/

	//Ultima Modificacion

	List<grupos> buscarPorUltimaModificacion(LocalDate localDate);

	List<grupos> buscarPorUltimaModificacionBefore(LocalDate localDate);

	List<grupos> buscarPorUltimaModificacionBeetwen(LocalDate date1, LocalDate date2);

	//CreatedAT

	List<grupos> buscarPorCreatedAT(LocalDate localDate);

	List<grupos> buscarPorCreatedATBefore(LocalDate localDate);

	List<grupos> buscarPorCreatedATBeetwen(LocalDate date1, LocalDate date2);

}
