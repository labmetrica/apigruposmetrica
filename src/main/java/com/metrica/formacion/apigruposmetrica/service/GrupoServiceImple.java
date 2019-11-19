package com.metrica.formacion.apigruposmetrica.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metrica.formacion.apigruposmetrica.dao.GrupoRepository;
import com.metrica.formacion.apigruposmetrica.entity.grupos;
import com.metrica.formacion.apigruposmetrica.exceptionHandler.*;

@Log4j2
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

		log.info("buscando grupo por id: " + id);

        return grupoRepository.findById(id).
                orElseThrow(() -> new CustomErrorResponse(grupos.class,"No existe grupo con el id: ",""));
	}

	@Override
	public grupos getByNombre(LocalTime localTime) {

		log.info("buscando grupo por nombre: " + localTime.toString());
		grupos grupo;

		try {

			grupo = grupoRepository.findByNombre(localTime);
		} catch (Exception e) {

		    throw new CustomErrorResponse(grupos.class,"No existe grupo " ,e.getMessage());
		}

		return grupo;
	}

	@Override
	public grupos guardarGrupo(grupos grupo) {

		grupos response;

		if((grupo.getHuecos() > 12) || (grupo.getHuecos() < 0)){

			throw new CustomErrorResponse(grupos.class,"los grupos no pueden tener más de 12 huecos, minimo 0","fuera de limites");
		}
		else{

			response = grupoRepository.save(grupo);
		}

		return response;
	}

	//borrar

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

	//createdAT

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

	//Ultima modificacion

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
