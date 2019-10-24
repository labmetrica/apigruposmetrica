package com.metrica.formacion.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.metrica.formacion.entity.Grupo;
import com.metrica.formacion.excepciones.grupoInexistenteException;
import com.metrica.formacion.excepciones.grupoLlenoException;

@Service
public class GrupoService implements GrupoInterface{
	
	private GrupoRepository repository;

	public Grupo getById(long id) {
		return repository.getById(id);
	}

	public Grupo getByNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	public Grupo getByHorario(Date horario) {
		return repository.findByHorario(horario);
	}
	
	public List<Grupo> getAll() {
		return repository.findAll();
	}

	public List<Grupo> getLibres() {
		return repository.getHuecosLibres();
	}

	public boolean updateGrupo(long id, Grupo actualizar) throws RuntimeException {
		if (repository.findById(id) == null) {
			throw new grupoInexistenteException(actualizar);
		}else {
			actualizar.setId(id);
			repository.save(actualizar);
			return true;
		}
	}

	public boolean deleteGrupo(long id) {
		try {
			repository.deleteById(id);
			if (repository.findById(id) == null) {
				return false;
			}
		} catch (Exception E) {
			return false;
		}
		return true;
	}

	public boolean moverDeGrupo(long IDoriginal, Grupo actualizar) throws RuntimeException {
		 
		sacarDeGrupo(IDoriginal);
		return false;
	}
	
	public boolean sacarDeGrupo (long id) throws RuntimeException {
		if (repository.comprobarGrupoExisteNoLleno(id) == null) {
			throw new grupoLlenoException();			
		}else {
			
		}
		return false;
	}
	
	public boolean meterEnGrupo (long id) {
		return false;
	}
}
