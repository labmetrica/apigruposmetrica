package com.metrica.formacion.apigruposmetrica.Controller;

import com.metrica.formacion.apigruposmetrica.Service.gruposService;
import com.metrica.formacion.apigruposmetrica.entity.grupos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/grupo")
public class gruposController {

    @Autowired
    private gruposService gruposService;

    @GetMapping("/mostrar")
    public List<grupos> mostrarGrupos(){

        return gruposService.mostrarGrupos();
    }

    @GetMapping("/buscarPorId/{id}")
    public grupos buscarPorId(@PathVariable("id") Integer id){

        return gruposService.buscarPorId(id);
    }

    @GetMapping("/buscarPorNombre/{nombre}")
    public grupos buscarPorNomnbre (@PathVariable("nombre")String localTime){

        LocalTime time = LocalTime.parse(localTime);

        return gruposService.buscarGrupo(time);
    }

}
