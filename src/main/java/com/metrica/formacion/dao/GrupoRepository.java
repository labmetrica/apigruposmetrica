package com.metrica.formacion.dao;

import java.time.LocalTime;
import java.util.List;

import com.metrica.formacion.entity.grupos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GrupoRepository extends JpaRepository<grupos, Integer>  {

	grupos findByNombre(LocalTime time1);
}
