package com.metrica.formacion.controler;

import java.time.LocalTime;
import java.util.List;

import com.metrica.formacion.entity.grupos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.metrica.formacion.service.GrupoServiceImple;


@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST , RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping("/grupos")
public class GrupoControler {
	
	@Autowired
	private GrupoServiceImple grupoService;

	/*GET*/

	@GetMapping("/grupo/{id}")
	public grupos getById(@PathVariable("id") final int id) {
		return grupoService.getById(id);
	}
	
	@GetMapping("/grupo/nombre/{nombre}")
	public grupos getByNombre(@PathVariable("nombre") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) final LocalTime nombre) {
		return grupoService.getByNombre(nombre);
	}

	@GetMapping("/grupos")
	public List<grupos> getAll() {
		return grupoService.getAll();
	}

	/*Delete*/

	@DeleteMapping("/grupo/{id}")
	public void  deleteGrupo(@PathVariable("id") final int id) {
		grupoService.borrarGrupo(id);
	}

	/*POST*/
	
	@PostMapping("/grupo/nuevo")
	public grupos newGrupo(final @RequestBody grupos actualizar) {
		return grupoService.guardarGrupo(actualizar) ;
	}

	/*PUT*/
	
	@PutMapping("/grupo/actualizar/{id}")
	public grupos updateGrupo(@PathVariable("id") final @RequestBody grupos actualizar) {
		return grupoService.guardarGrupo(actualizar);
	}
}

