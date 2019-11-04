package com.metrica.formacion.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.metrica.formacion")
@ComponentScan("com.metrica.formacion")
@EntityScan("com.metrica.formacion")
@EnableDiscoveryClient
public class SpringConfigurationFile {

}
