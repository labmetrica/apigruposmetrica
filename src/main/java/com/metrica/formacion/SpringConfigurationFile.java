package com.metrica.formacion;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.metrica.formacion")
@ComponentScan("com.metrica.formacion")
@EntityScan("com.metrica.formacion")
public class SpringConfigurationFile {

}
