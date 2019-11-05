package com.metrica.formacion;


import com.metrica.formacion.dao.GrupoRepository;
import com.metrica.formacion.entity.grupos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

@SpringBootTest(classes = SpringConfigurationFile.class)
public class TestService {

	@Autowired
	private GrupoRepository grupoRepository;

	@Test
	public void test() {

		grupos grupos = grupoRepository.findByNombre(LocalTime.of(13,30,00));

		Assertions.assertEquals("13:30:00", grupos.getNombre().toString());
	}
	
}
