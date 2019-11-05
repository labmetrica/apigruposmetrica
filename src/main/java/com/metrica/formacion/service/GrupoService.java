package com.metrica.formacion.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metrica.formacion.dao.GrupoRepository;
import com.metrica.formacion.entity.Grupo;

@Service
public class GrupoService implements GrupoInterface {
	
	@Autowired(required=true)
	private static GrupoRepository grupoRepository;

	public Grupo getById(final int id) {
		return grupoRepository.findById(id).orElse(new Grupo());
	}

	@Override
	public Grupo getByNombre(LocalTime nombre) {
		return grupoRepository.findByNombre(nombre);
	}

	@Override
	public List<Grupo> getAll() {
		return grupoRepository.findAll();
	}

	@Override
	public boolean updateGrupo(int id, Grupo actualizar) {
		Grupo userBD = grupoRepository.findById(id).orElse(new Grupo());
		if (userBD != new Grupo()) {
			actualizar.setId(id);
			actualizar.setUltima_modificacion();
			grupoRepository.save(actualizar);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteGrupo(int id) {
		try {
			grupoRepository.deleteById(id);
			return true;
		} catch (Exception E) {
			return false;
		}
	}

	@Override
	public boolean deleteAllGrupos() {
		try {
			grupoRepository.deleteAll();
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
		Grupo userBD = grupoRepository.findById(id).orElse(new Grupo());
		if (userBD != new Grupo()) {
			userBD.setHuecosMas1();
			userBD.setUltima_modificacion();
			grupoRepository.save(userBD);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean meterEnGrupo(int id) {
		Grupo userBD = grupoRepository.findById(id).orElse(new Grupo());
		if (userBD != new Grupo()) {
			userBD.setHuecosMenos1();
			userBD.setUltima_modificacion();
			grupoRepository.save(userBD);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean newGrupo(Grupo nuevo) {
		Grupo userBD = grupoRepository.findById(nuevo.getId()).orElse(new Grupo());
		if (userBD != new Grupo()) {
			nuevo.setCreatedAT(LocalDateTime.now());
			nuevo.setUltima_modificacion();
			grupoRepository.save(nuevo);
			return true;
		} else {
			return false;
		}
	}

}
