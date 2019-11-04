package com.metrica.formacion.dao;

import com.metrica.formacion.config.SpringConfigurationFile;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpringConfigurationFile.class)
@Transactional
class GrupoRepositoryTest {

}