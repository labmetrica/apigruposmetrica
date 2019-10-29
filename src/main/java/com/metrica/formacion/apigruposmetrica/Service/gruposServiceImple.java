package com.metrica.formacion.apigruposmetrica.Service;

import com.metrica.formacion.apigruposmetrica.dao.grupoRepository;
import com.metrica.formacion.apigruposmetrica.entity.grupos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class gruposServiceImple implements gruposService{

    @Autowired
    private grupoRepository gruposRepository;

    @Override
    public grupos crearGrupo(grupos grupos) {
        return gruposRepository.save(grupos);
    }

    @Override
    public grupos buscarGrupo(LocalTime localTime) {
        return gruposRepository.findByNombre(localTime);
    }

    @Override
    public List<grupos> mostrarGrupos() {
        return gruposRepository.findAll();
    }

    @Override
    public grupos buscarPorId(Integer integer) {
        return gruposRepository.findById(integer).isPresent() ? gruposRepository.findById(integer).get() : null;
    }
}
