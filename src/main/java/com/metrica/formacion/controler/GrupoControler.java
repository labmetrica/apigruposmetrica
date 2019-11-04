package com.metrica.formacion.controler;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.metrica.formacion.entity.Grupo;
import com.metrica.formacion.entity.GrupoDTO;
import com.metrica.formacion.service.GrupoService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RestController
@RequestMapping("/datos")
public class GrupoControler {

	@Autowired
	private GrupoService grupoService;

	@GetMapping("/grupo/{id}")
	public GrupoDTO getById(@PathVariable("id") final int id) {
		return grupoService.getById(id);
	}

	@GetMapping("/grupo/nombre")
	public GrupoDTO getByNombre(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) final Time nombre) {
		return grupoService.getByNombre(nombre);
	}

	@GetMapping("/grupos")
	public List<GrupoDTO> getAll() {
		return grupoService.getAll();
	}

	@GetMapping("/grupos/libres")
	public List<GrupoDTO> getLibres() {
		return grupoService.getLibres();
	}

	@DeleteMapping("/grupo/{id}")
	public boolean deleteGrupo(@PathVariable("id") final int id) {
		return grupoService.deleteGrupo(id);
	}
	
	@DeleteMapping()
	public boolean deleteAllGrupos () {
		return grupoService.deleteAllGrupos();
	}

	@PutMapping("/grupo/nuevo")
	public boolean newGrupo(final @RequestBody Grupo actualizar) {
		return grupoService.newGrupo(actualizar);
	}

	@PutMapping("/grupo/actualizar/{id}")
	public boolean updateGrupo(@PathVariable("id") final int id, final @RequestBody Grupo actualizar) {
		return grupoService.updateGrupo(id, actualizar);
	}

	@PutMapping("/grupo/sacar/{id}")
	public boolean sacarDeGrupo(@PathVariable("id") final int id) {
		return grupoService.sacarDeGrupo(id);
	}

	@PutMapping("/grupo/meter/{id}")
	public boolean meterEnGrupo(@PathVariable("id") final int id) {
		return grupoService.meterEnGrupo(id);
	}

	@PutMapping("/grupo/mover/{idOriginal}-{idActualizar}")
	public boolean moverDeGrupo(@PathVariable("idOriginal") final int idOriginal,
			@PathVariable("idActualizar") final int idActualizar) {
		return grupoService.moverDeGrupo(idOriginal, idActualizar);
	}
}
