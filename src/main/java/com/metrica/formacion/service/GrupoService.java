package com.metrica.formacion.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metrica.formacion.dao.GrupoRepository;
import com.metrica.formacion.entity.Grupo;


@Service
public class GrupoService implements GrupoInterface{
	
	@Autowired
	private GrupoRepository repository;
	
	// ITS ALIIIIVE
	public Grupo getById(final long id) {
		return repository.findById(id).orElse(new Grupo());
	}

	@Override
	public Date getByNombre(Date nombre) {
		return repository.findByNombre(nombre);
	}
	// ITS ALIIIIVE
	@Override
	public List<Grupo> getAll() {
		return repository.findAll();
	}

	// ITS ALIIIIVE
	@Override
	public List<Grupo> getLibres() {
		return repository.getHuecosLibres();
	}

	@Override
	public boolean updateGrupo(long id, Grupo actualizar) throws RuntimeException {
		if (repository.findById(id) == null) {
			return false;
			//throw new grupoInexistenteException(actualizar);
		}else {
			actualizar.setId(id);
			repository.save(actualizar);
			return true;
		}
	}

	// ITS ALIIIIVE
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
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean sacarDeGrupo (long id) { 
		if (repository.findById(id) != null) {
			repository.menos1hueco(id);
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean meterEnGrupo (long id) {
		if (repository.comprobarGrupoExisteNoLleno(id) != null) {
			repository.menos1hueco(id);
			return true;
		}else {
			return false;
		}	
	}
	
}
