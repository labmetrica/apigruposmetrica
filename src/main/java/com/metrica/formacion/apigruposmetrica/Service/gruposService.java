package com.metrica.formacion.apigruposmetrica.Service;

import com.metrica.formacion.apigruposmetrica.entity.grupos;

import java.time.LocalTime;
import java.util.List;

public interface gruposService {

    grupos crearGrupo(grupos grupos);

    grupos buscarPorId(Integer integer);

    grupos buscarGrupo(LocalTime localTime);

    List<grupos> mostrarGrupos();
}
