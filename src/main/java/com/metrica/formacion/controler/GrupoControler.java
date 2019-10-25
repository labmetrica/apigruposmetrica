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

import com.metrica.formacion.entity.Grupo;
import com.metrica.formacion.service.GrupoService;


@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST , RequestMethod.PUT})
@RestController
@RequestMapping("/datos")
public class GrupoControler {
	
	@Autowired
	private GrupoService grupoService;

	// ITS ALIIIIVE
	@GetMapping("/grupo/{id}")
	public Grupo getById(@PathVariable("id") final Long id) {
		return grupoService.getById(id);
	}
	
	@GetMapping("/grupo/nombre/{nombre}")
	public Date getByNombre(@PathVariable("nombre") final Date nombre) {
		return grupoService.getByNombre(nombre);
	}
	// ITS ALIIIIVE
	@GetMapping("/grupos")
	public List<Grupo> getAll() {
		return grupoService.getAll();
	}
	// ITS ALIIIIVE
	@GetMapping("/grupos/libres")
	public List<Grupo> getLibres() {
		return grupoService.getLibres();
	}
	
	@PutMapping("/grupo/{id}")
	public boolean update(@PathVariable("id")final long id, final @RequestBody Grupo actualizar) {
		return grupoService.updateGrupo(id, actualizar);
	}
	
	// ITS ALIIIIVE
	@DeleteMapping("/grupo/{id}")
	public boolean deleteGrupo(@PathVariable("id") final long id) {
		return grupoService.deleteGrupo(id);
	}
	
	
	@GetMapping("/grupo/sacar/{id}")
	public boolean sacarDeGrupo (@PathVariable("id") final long id) {
		return grupoService.sacarDeGrupo(id);
	}
	
	@GetMapping("/grupo/meter/{id}")
	public boolean meterEnGrupo(@PathVariable("id") final long id) {
		return grupoService.meterEnGrupo(id);
	}
	
	@GetMapping("/grupo/mover/{idOriginal}-{idActualizar}")
	public boolean moverDeGrupo(@PathVariable("idOriginal") final long idOriginal, @PathVariable("idActualizar") final long idActualizar) {
		return grupoService.moverDeGrupo(idOriginal, idActualizar);
	}
}
