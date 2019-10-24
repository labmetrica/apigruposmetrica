package com.metrica.formacion.controler;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metrica.formacion.dao.GrupoService;
import com.metrica.formacion.entity.Grupo;


@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/datos")
public class GrupoControler {
	
	@Autowired
	private GrupoService grupoService;


	@GetMapping("/grupo/{id}")
	public Grupo getById(@PathVariable("id") final Long id) {
		return grupoService.getById(id);
	}
	
	@GetMapping("/grupo/nombre/{nombre}")
	public Grupo getByNombre(@PathVariable("nombre") final String nombre) {
		return grupoService.getByNombre(nombre);
	}
	
	@GetMapping("/grupo/hora/{horario}")
	public Grupo getByHorario(@PathVariable("horario") final Date horario) {
		return grupoService.getByHorario(horario);
	}
	
	@GetMapping("/grupos")
	public List<Grupo> getAll() {
		return grupoService.getAll();
	}

	@GetMapping("/grupos/libres/{horas}")
	public List<Grupo> getLibres() {
		return grupoService.getLibres();
	}
	
	@PutMapping("/grupo/{id}")
	public boolean update(@PathVariable("id")final long id, final @RequestBody Grupo actualizar) {
		return grupoService.updateGrupo(id, actualizar);
	}
	
	@DeleteMapping("/grupo/{id}")
	public boolean deleteGrupo(@PathVariable("id") final Long id) {
		return grupoService.deleteGrupo(id);
	}

	
}
