package com.metrica.formacion;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.metrica.formacion.entity.Grupo;
import com.metrica.formacion.service.GrupoService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringConfigurationFile.class)
public class TestService {
	
	@Autowired
	private GrupoService testService;
	
	
}
