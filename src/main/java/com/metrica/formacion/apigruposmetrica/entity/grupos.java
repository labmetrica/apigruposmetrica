package com.metrica.formacion.apigruposmetrica.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "grupos")
public class grupos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "nombre")
    private LocalTime nombre;

    @Column(name = "createdAT")
    private LocalDateTime createdAT;

    @Column(name = "ultima_modificacion")
    private LocalDateTime ultima_modificacion;

    @Column(name = "huecos")
    private int huecos;



    public grupos() {

        huecos = 12;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getNombre() {
        return nombre;
    }

    public void setNombre(LocalTime nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(LocalDateTime createdAT) {
        this.createdAT = createdAT;
    }

    public LocalDateTime getUltima_modificacion() {
        return ultima_modificacion;
    }

    public void setUltima_modificacion(LocalDateTime ultima_modificacion) {
        this.ultima_modificacion = ultima_modificacion;
    }

    //

    public void agreagarHueco (){

        if(huecos < 12){

            huecos++;
        }
    }

    public void quitarHueco (){


        if (huecos > 0) {

            huecos --;
        }
    }

    //
    public int getHuecos() {
        return huecos;
    }

    public void setHuecos(int huecos) {
        this.huecos = huecos;
    }
}
