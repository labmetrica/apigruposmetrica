package com.metrica.formacion.dao;

import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metrica.formacion.entity.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Object> {

	Grupo findByNombre(LocalTime time1);

}
