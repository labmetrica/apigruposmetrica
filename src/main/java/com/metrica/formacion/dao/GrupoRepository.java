package com.metrica.formacion.dao;

import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metrica.formacion.entity.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Object> {

	Grupo findByNombre(LocalTime time1);

}
