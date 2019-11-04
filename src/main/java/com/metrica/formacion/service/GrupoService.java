package com.metrica.formacion.service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metrica.formacion.dao.GrupoRepository;
import com.metrica.formacion.dao.converter.GrupoDTOGrupoConverter;
import com.metrica.formacion.dao.converter.GrupoGrupoDTOConverter;
import com.metrica.formacion.entity.Grupo;
import com.metrica.formacion.entity.GrupoDTO;

@Service
public class GrupoService implements GrupoInterface {

	@Autowired
	private static GrupoRepository repository;
	private static final Optional<Grupo> optionalVacio = Optional.empty();
	private GrupoGrupoDTOConverter GrupoToDTO;
	private GrupoDTOGrupoConverter DTOtoGrupo;

	public GrupoDTO getById(final int id) {
		return GrupoToDTO.convert(repository.findById(id).orElse(new Grupo()));
	}

	@Override
	public GrupoDTO getByNombre(Time nombre) {
		return GrupoToDTO.convert(repository.findByNombre(nombre));
	}

	@Override
	public List<GrupoDTO> getAll() {
		return GrupoToDTO.convert(repository.findAll());
	}

	@Override
	public List<GrupoDTO> getLibres() {
		return GrupoToDTO.convert(repository.getHuecosLibres());
	}

	@Override
	public boolean updateGrupo(int id, Grupo actualizar) {
		if (repository.findById(id) != optionalVacio) {
			actualizar.setId(id);
			setUltimaModificacion(actualizar);
			repository.save(actualizar);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteGrupo(int id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception E) {
			return false;
		}
	}

	@Override
	public boolean moverDeGrupo(int idOriginal, int idActualizar) {
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
	public boolean sacarDeGrupo(int id) {
		if (repository.findById(id) != optionalVacio) {
			repository.mas1Hueco(id);
			setUltimaModificacion(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean meterEnGrupo(int id) {
		if (repository.comprobarGrupoExisteNoLleno(id) != new Grupo()) {
			repository.menos1hueco(id);
			setUltimaModificacion(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean newGrupo(Grupo nuevo) {
		if (repository.findById(nuevo.getId()) != optionalVacio) {
			setUltimaModificacion(nuevo);
			nuevo.setCreatedAT(Timestamp.valueOf(LocalDateTime.now()));
			repository.save(nuevo);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Este metodo cambia en un objeto Grupo la ultima modificacion del grupo al
	 * momento actual.
	 * 
	 * @param aCambiar objeto al que se le va a actualizar la variale
	 *                 ultima_modificacion
	 */
	private Grupo setUltimaModificacion(Grupo aCambiar) {
		aCambiar.setUltima_modificacion(Timestamp.valueOf(LocalDateTime.now()));
		return aCambiar;
	}

	/**
	 * Este metodo cambia en la base de datos el valor de la ultima modificacion del
	 * grupo al momento actual.
	 * 
	 * @param id Este es el id que se utiliza en la Base de datos para identificar
	 *           el grupo
	 */
	private void setUltimaModificacion(int id) {
		repository.updateUltimaModificacion(Timestamp.valueOf(LocalDateTime.now()), id);
	}

}
