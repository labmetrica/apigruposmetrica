package com.metrica.formacion.apigruposmetrica.excepciones;

import com.metrica.formacion.apigruposmetrica.entity.grupos;

public class grupoInexistenteException extends RuntimeException {
    private grupos inexistente;

    public grupoInexistenteException(grupos falta) {
        this.inexistente = falta;
    }
}
