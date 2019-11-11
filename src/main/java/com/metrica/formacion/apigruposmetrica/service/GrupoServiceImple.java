package com.metrica.formacion.apigruposmetrica.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metrica.formacion.apigruposmetrica.dao.GrupoRepository;
import com.metrica.formacion.apigruposmetrica.entity.grupos;

@Service
public class GrupoServiceImple implements GrupoService {
  
	@Autowired
	private GrupoRepository grupoRepository;

	@Override
	public List<grupos> getAll() {
		return grupoRepository.findAll();
	}

	@Override
	public grupos getById(int id) {
		return grupoRepository.findById(id).get();
	}

	@Override
	public grupos getByNombre(LocalTime localTime) {
		return grupoRepository.findByNombre(localTime);
	}

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

    @Override
    public void borrarTodo() {
        grupoRepository.deleteAll();
    }

    /* Busqueda por fechas */

	@Override
	public List<grupos> buscarPorCreatedAT(LocalDate localdate) {
		return grupoRepository.findByCreatedAT(localdate.toString());
	}

	@Override
	public List<grupos> buscarPorCreatedATBefore(LocalDate localdate) {
		return grupoRepository.findByCreatedATBefore(localdate.atTime(23, 59, 59));
	}

	@Override
	public List<grupos> buscarPorCreatedATBeetwen(LocalDate date1, LocalDate date2) {
		return grupoRepository.findByCreatedATBetween(date1.atTime(23, 59, 59), date2.atTime(23, 59, 59));

	}

	//

	@Override
	public List<grupos> buscarPorUltimaModificacion(LocalDate localdate) {
		return grupoRepository.findByUltimaModificacion(localdate.toString());
	}

	@Override
	public List<grupos> buscarPorUltimaModificacionBefore(LocalDate localdate) {
		return grupoRepository.findByUltimaModificacionBefore(localdate.atTime(23, 59, 95));

	}

	@Override
	public List<grupos> buscarPorUltimaModificacionBeetwen(LocalDate date1, LocalDate date2) {
		return grupoRepository.findByUltimaModificacionBetween(date1.atTime(23, 59, 59), date2.atTime(23, 59, 59));

	}
}
