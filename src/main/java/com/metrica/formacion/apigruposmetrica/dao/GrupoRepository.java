package com.metrica.formacion.apigruposmetrica.dao;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.metrica.formacion.apigruposmetrica.entity.grupos;

public interface GrupoRepository extends JpaRepository<grupos, Integer> {

	grupos findByNombre(LocalTime time1);

	/* Buscar por fechas */

	// CreatedAT

	List<grupos> findByCreatedATBetween(LocalDateTime fecha1, LocalDateTime fecha2);

	@Query(value = "SELECT * FROM grupos WHERE DATE(grupos.createdAT) = ?1", nativeQuery = true)
	List<grupos> findByCreatedAT(String date);

	List<grupos> findByCreatedATBefore(LocalDateTime localDateTime);

	// Ultima modificacion

	@Query(value = "SELECT * FROM grupos WHERE DATE(grupos.ultimaModificacion) = ?1", nativeQuery = true)
	List<grupos> findByUltimaModificacion(String fecha);

	List<grupos> findByUltimaModificacionBefore(LocalDateTime localDateTime);

	List<grupos> findByUltimaModificacionBetween(LocalDateTime fecha1, LocalDateTime fecha2);
}
