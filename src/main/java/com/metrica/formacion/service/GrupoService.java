package com.metrica.formacion.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metrica.formacion.dao.GrupoRepository;
import com.metrica.formacion.entity.Grupo;


@Service
public class GrupoService implements GrupoInterface{
	
	@Autowired
	private static GrupoRepository repository;
	private static final Optional<Grupo> optionalVacio = Optional.empty();

	
	public Grupo getById(final long id) {
		return repository.findById(id).orElse(new Grupo());
	}

	@Override
	public Grupo getByNombre(LocalTime nombre) {
		return repository.findByNombre(nombre);
	}
	@Override
	public List<Grupo> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Grupo> getLibres() {
		return repository.getHuecosLibres();
	}

	@Override
	public boolean updateGrupo(long id, Grupo actualizar) {
		if (repository.findById(id) != optionalVacio ) {
			actualizar.setId(id);
			setUltimaModificacion(actualizar);
			repository.save(actualizar);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteGrupo(long id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception E) {
			return false;
		}
	}

	@Override
	public boolean moverDeGrupo(long idOriginal, long idActualizar) {
		if (!sacarDeGrupo(idOriginal)) {
			return false;
		}
		if (!meterEnGrupo(idActualizar)) {
			meterEnGrupo(idOriginal);
			return false;
		}		
		return true;
	}
	
	@Override
	public boolean sacarDeGrupo (long id) { 
		if (repository.findById(id) != optionalVacio ){
			repository.mas1Hueco(id);
			setUltimaModificacion(id);
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean meterEnGrupo (long id) {
		if (repository.comprobarGrupoExisteNoLleno(id) != new Grupo()) {
			repository.menos1hueco(id);
			setUltimaModificacion(id);
			return true;
		}else {
			return false;
		}	
	}

	@Override
	public boolean newGrupo(Grupo nuevo) {
		if (repository.findById(nuevo.getId()) != optionalVacio) {
			setUltimaModificacion(nuevo);
			nuevo.setCreatedAT(LocalDateTime.now());
			repository.save(nuevo);
			return true;			
		}else{
			return false;
		}
	}
	
	/**
	 * Este metodo cambia en un objeto Grupo la ultima modificacion del grupo al momento actual.
	 *  @param aCambiar objeto al que se le va a actualizar la variale ultima_modificacion 
	 * */
	private Grupo setUltimaModificacion(Grupo aCambiar) {
		aCambiar.setUltima_modificacion(LocalDateTime.now());
		return aCambiar;
	}
	
	/**
	 * Este metodo cambia en la base de datos el valor de la ultima modificacion del grupo al momento actual.
	 * @param id Este es el id que se utiliza en la Base de datos para identificar el grupo  
	 *  */
	private void setUltimaModificacion(long id) {
		repository.updateUltimaModificacion(LocalDateTime.now(), id);
	}
	
}
