package com.metrica.formacion.apigruposmetrica.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metrica.formacion.apigruposmetrica.dao.GrupoRepository;
import com.metrica.formacion.apigruposmetrica.entity.grupos;
import com.metrica.formacion.apigruposmetrica.excepciones.BorrarGrupoNotFoundException;
import com.metrica.formacion.apigruposmetrica.excepciones.BorrarIdNotFoundException;
import com.metrica.formacion.apigruposmetrica.excepciones.BuscarFechaAntesNotFoundException;
import com.metrica.formacion.apigruposmetrica.excepciones.BuscarFechaEntreNotFoundException;
import com.metrica.formacion.apigruposmetrica.excepciones.BuscarFechaNotFoundException;
import com.metrica.formacion.apigruposmetrica.excepciones.BuscarIdNotFoundException;
import com.metrica.formacion.apigruposmetrica.excepciones.BuscarModificacionAntesNotFoundException;
import com.metrica.formacion.apigruposmetrica.excepciones.BuscarModificacionEntreNotFoundException;
import com.metrica.formacion.apigruposmetrica.excepciones.BuscarModificacionNotFoundException;
import com.metrica.formacion.apigruposmetrica.excepciones.BuscarNombreNotFoundException;
import com.metrica.formacion.apigruposmetrica.excepciones.GrupoIdNotFoundException;
import com.metrica.formacion.apigruposmetrica.excepciones.ListarUsuariosNotFoundException;

@Service
public class GrupoServiceImple implements GrupoService {

	@Autowired
	private GrupoRepository grupoRepository;

	@Override
	public List<grupos> getAll() {
		if (grupoRepository.findAll() != null) {
			return grupoRepository.findAll();
		} else {
			throw new ListarUsuariosNotFoundException();
		}
	}

	@Override
	public grupos getById(int id) {

		if (grupoRepository.existsById(id)) {

			return grupoRepository.findById(id).get();
		} else {
			throw new BuscarIdNotFoundException(id);
		}

	}

	@Override
	public grupos getByNombre(LocalTime localTime) {
		if (grupoRepository.findByNombre(localTime) != null) {
			return grupoRepository.findByNombre(localTime);
		} else {
			throw new BuscarNombreNotFoundException(localTime);
		}
	}

	@Override
	public grupos guardarGrupo(grupos grupo) {
		if (grupoRepository.existsById(grupo.getId()) || grupoRepository.exists(grupo.getNombre())) {
			throw new GrupoIdNotFoundException(grupo);
		} else {
			return grupoRepository.save(grupo);
		}
	}

	@Override
	public void borrarGrupo(int id) {
		if (grupoRepository.existsById(id)) {
			grupoRepository.deleteById(id);
		} else {
			throw new BorrarIdNotFoundException(id);
		}
	}

	@Override
	public void borrarGrupo(grupos grupo) {
		if (grupoRepository.existsById(grupo.getId())) {
			grupoRepository.delete(grupo);
		} else {
			throw new BorrarGrupoNotFoundException(grupo);
		}
	}

	/* Busqueda por fechas */

	@Override
	public List<grupos> buscarPorCreatedAT(LocalDate localdate) {
		if (grupoRepository.findByCreatedAT(localdate.toString()) != null) {
			return grupoRepository.findByCreatedAT(localdate.toString());
		} else {
			throw new BuscarFechaNotFoundException(localdate);
		}
	}

	@Override
	public List<grupos> buscarPorCreatedATBefore(LocalDate localdate) {
		if (grupoRepository.findByCreatedATBefore(localdate.atTime(23, 59, 59)) != null) {
			return grupoRepository.findByCreatedATBefore(localdate.atTime(23, 59, 59));
		} else {
			throw new BuscarFechaAntesNotFoundException(localdate);
		}
	}

	@Override
	public List<grupos> buscarPorCreatedATBeetwen(LocalDate date1, LocalDate date2) {
		if (grupoRepository.findByCreatedATBetween(date1.atTime(23, 59, 59), date2.atTime(23, 59, 59)) != null) {
			return grupoRepository.findByCreatedATBetween(date1.atTime(23, 59, 59), date2.atTime(23, 59, 59));
		} else {
			throw new BuscarFechaEntreNotFoundException(date1, date2);
		}
	}

	//

	@Override
	public List<grupos> buscarPorUltimaModificacion(LocalDate localdate) {
		if (grupoRepository.findByUltimaModificacion(localdate.toString()) != null) {
			return grupoRepository.findByUltimaModificacion(localdate.toString());
		} else {
			throw new BuscarModificacionNotFoundException(localdate);
		}
	}

	@Override
	public List<grupos> buscarPorUltimaModificacionBefore(LocalDate localdate) {
		if (grupoRepository.findByUltimaModificacionBefore(localdate.atTime(23, 59, 95)) != null) {
			return grupoRepository.findByUltimaModificacionBefore(localdate.atTime(23, 59, 95));
		} else {
			throw new BuscarModificacionAntesNotFoundException(localdate);
		}
	}

	@Override
	public List<grupos> buscarPorUltimaModificacionBeetwen(LocalDate date1, LocalDate date2) {
		if (grupoRepository.findByUltimaModificacionBetween(date1.atTime(23, 59, 59),
				date2.atTime(23, 59, 59)) != null) {
			return grupoRepository.findByUltimaModificacionBetween(date1.atTime(23, 59, 59), date2.atTime(23, 59, 59));
		} else {
			throw new BuscarModificacionEntreNotFoundException(date1, date2);
		}
	}
}
