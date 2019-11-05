package com.metrica.formacion.controler;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metrica.formacion.entity.Grupo;
import com.metrica.formacion.service.GrupoService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RestController
@RequestMapping("/datos")
public class GrupoControler {

	@Autowired(required=true)
	private GrupoService grupoService;

	@GetMapping("/grupo/{id}")
	public Grupo getById(@PathVariable("id") final int id) {
		return grupoService.getById(id);
	}

	@GetMapping("/grupo/nombre")
	public Grupo getByNombre(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) final LocalTime nombre) {
		return grupoService.getByNombre(nombre);
	}

	@GetMapping("/grupos")
	public List<Grupo> getAll() {
		return grupoService.getAll();
	}

	@DeleteMapping("/grupo/{id}")
	public boolean deleteGrupo(@PathVariable("id") final int id) {
		return grupoService.deleteGrupo(id);
	}

	@DeleteMapping("/grupos")
	public boolean deleteAllGrupos() {
		return grupoService.deleteAllGrupos();
	}

	@PostMapping("/grupo/nuevo")
	public boolean newGrupo(final @RequestBody Grupo actualizar) {
		return grupoService.newGrupo(actualizar);
	}

	@PutMapping("/grupo/actualizar/{id}")
	public boolean updateGrupo(@PathVariable("id") final int id, final @RequestBody Grupo actualizar) {
		return grupoService.updateGrupo(id, actualizar);
	}

}
