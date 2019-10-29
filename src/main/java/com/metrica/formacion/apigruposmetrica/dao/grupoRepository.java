package com.metrica.formacion.apigruposmetrica.dao;

import com.metrica.formacion.apigruposmetrica.entity.grupos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;

@Repository
public interface grupoRepository extends JpaRepository<grupos, Integer> {

    grupos findByNombre (LocalTime localTime);
}
