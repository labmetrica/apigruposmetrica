package com.metrica.formacion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.metrica.formacion.entity.Grupo;
import com.metrica.formacion.service.GrupoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringConfigurationFile.class)
@DataJpaTest
public class TestService {

	private GrupoService metodos = new GrupoService();
	private Grupo testGrupo = new Grupo(1);

	@Test
	public void testIdInexistentes() {
		assertFalse(metodos.updateGrupo(3454, testGrupo));
		assertFalse(metodos.deleteGrupo(3454));
		assertFalse(metodos.moverDeGrupo(1, 3454));
		assertFalse(metodos.moverDeGrupo(3454, 1));
		assertNull(metodos.getById(3454));

	}
	
	public void testIdExistentes() {
		assertFalse(metodos.newGrupo(testGrupo));
		assertFalse(metodos.deleteGrupo(3454));
		assertFalse(metodos.moverDeGrupo(1, 3454));
		assertFalse(metodos.moverDeGrupo(3454, 1));
		assertNull(metodos.getById(3454));

	}

}
