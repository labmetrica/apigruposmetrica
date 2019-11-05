package com.metrica.formacion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.metrica.formacion.entity.Grupo;
import com.metrica.formacion.service.GrupoService;

@SpringBootTest(classes = SpringConfigurationFile.class)
@DataJpaTest
public class TestService {

	@Autowired
	private GrupoService metodos = new GrupoService();
	private Grupo testGrupo = new Grupo();
	

	@Test
	public void testIdInexistentes() {
		testGrupo.setId(1);
		assertFalse(metodos.updateGrupo(3454, testGrupo));
		assertFalse(metodos.deleteGrupo(3454));
		assertNull(metodos.getById(3454));
	}

	@Test
	public void testIdExistentes() {
		assertFalse(metodos.newGrupo(testGrupo));
	}

	@Test
	public void testBorrados() {
		metodos.deleteGrupo(1);
		assertNull(metodos.getById(1));

		metodos.deleteAllGrupos();
		assertNull(metodos.getById(2));
	}

}