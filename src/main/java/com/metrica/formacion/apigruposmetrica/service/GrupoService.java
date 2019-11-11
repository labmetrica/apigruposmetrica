package com.metrica.formacion.apigruposmetrica.service;

import com.metrica.formacion.apigruposmetrica.entity.grupos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface GrupoService {

    List<grupos> getAll();

    grupos getById(int id);

    grupos getByNombre(LocalTime localTime);

    grupos guardarGrupo(grupos grupo);

    void borrarGrupo(int id);

    void borrarGrupo(grupos grupo);

    void borrarTodo();

    /*BuscarPorFechas*/

    //Ultima Modificacion

    List<grupos> buscarPorUltimaModificacion(LocalDate localDate);

    List<grupos> buscarPorUltimaModificacionBefore(LocalDate localDate);

    List<grupos> buscarPorUltimaModificacionBeetwen(LocalDate date1, LocalDate date2);

    //CreatedAT

    List<grupos> buscarPorCreatedAT(LocalDate localDate);

    List<grupos> buscarPorCreatedATBefore(LocalDate localDate);

    List<grupos> buscarPorCreatedATBeetwen(LocalDate date1, LocalDate date2);

}
