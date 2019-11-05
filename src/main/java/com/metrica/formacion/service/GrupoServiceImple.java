package com.metrica.formacion.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metrica.formacion.dao.GrupoRepository;
import com.metrica.formacion.entity.grupos;


@Service
public class GrupoServiceImple implements GrupoService {

	@Autowired(required=true)
	private GrupoRepository grupoRepository;

	//Busquedas
	@Override
	public List<grupos> getAll() {
		return grupoRepository.findAll();
	}

	@Override
	public grupos getById(int id) {
		return grupoRepository.findById(id).orElse(null);
	}

	//Cambios en BDD
	@Override
	public grupos guardarGrupo(grupos grupo) {
		return grupoRepository.save(grupo);
	}

	@Override
	public void borrarGrupo(int id) {
		grupoRepository.deleteById(id);
	}

	@Override
	public void borrarGrupo(grupos grupo) {
		grupoRepository.delete(grupo);
	}
	
	public void borrarTodosGrupos() {
		grupoRepository.deleteAll();
	}


	// BUSQUEDAS POR FECHAS
	
	
	// Busqueda por nombre
	
	@Override
	public grupos getByNombre(LocalTime localTime) {
		return grupoRepository.findByNombre(localTime);
	}

	
	// Busqueda por la creacion de la entrada

	@Override
	public List<grupos> buscarPorCreatedAT(LocalDate localDate) {
		return grupoRepository.findByCreatedAT(localDate.toString());
	}

	@Override
	public List<grupos> buscarPorCreatedATBefore(LocalDate localDate) {
		return grupoRepository.findByCreatedATBefore(localDate.atTime(23,59,59));
	}

	@Override
	public List<grupos> buscarPorCreatedATBeetwen(LocalDate date1, LocalDate date2) {
		return grupoRepository.findByCreatedATBetween(date1.atTime(23,59,59)
		, date2.atTime(23,59,59));
	}


	// Busqueda por ultima modificacion

	@Override
	public List<grupos> buscarPorUltimaModificacion(LocalDate localDate) {
		return grupoRepository.findByUltimaModificacion(localDate.toString());
	}

	@Override
	public List<grupos> buscarPorUltimaModificacionBefore(LocalDate localDate) {
		return grupoRepository.findByUltimaModificacionBefore(localDate.atTime(23,59,59));
	}

	@Override
	public List<grupos> buscarPorUltimaModificacionBeetwen(LocalDate date1, LocalDate date2) {
		return grupoRepository.findByUltimaModificacionBetween(date1.atTime(23,59,59),
				date2.atTime(23,59,59));
	}
}
