package com.metrica.formacion.apigruposmetrica.controller;

import com.metrica.formacion.apigruposmetrica.entity.grupos;
import com.metrica.formacion.apigruposmetrica.service.GrupoServiceImple;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoServiceImple grupoService;

    /*GET*/

    @GetMapping("/buscarPorId/{id}")
    public grupos getById(@PathVariable("id") final int id) {
        log.info("buscando grupo, id : " + id);
        return grupoService.getById(id);
    }

    @GetMapping("/buscarPorNombre/{nombre}")
    public grupos getByNombre(@PathVariable("nombre") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) final LocalTime nombre) {
        return grupoService.getByNombre(nombre);
    }

    @GetMapping("/lista-grupos")
    public List<grupos> getAll() {
        log.info("mostrando lista de grupos");
        return grupoService.getAll();
    }

    /*Delete*/

    @DeleteMapping("/borrarPorId/{id}")
    public void deleteGrupo(@PathVariable("id") final int id) {
        grupoService.borrarGrupo(id);
    }

    @DeleteMapping("/borrarTODO")
    public void borrarTodo(){
        grupoService.borrarTodo();
    }

    /*POST*/

    @PostMapping("/crearGrupo")
    public grupos newGrupo(final @RequestBody grupos actualizar) {

        return grupoService.guardarGrupo(actualizar);
    }

    /*PUT*/

    @PutMapping("/actualizarGrupo")
    public grupos updateGrupo(@RequestBody grupos actualizar) {
        return grupoService.guardarGrupo(actualizar);
    }
}

