package com.metrica.formacion.apigruposmetrica.excepciones;

import com.metrica.formacion.apigruposmetrica.entity.grupos;

public class grupoLlenoException extends RuntimeException {
    private grupos lleno;

    public grupoLlenoException(grupos lleno) {
        this.lleno = lleno;
    }

    public grupoLlenoException() {
    }
}
