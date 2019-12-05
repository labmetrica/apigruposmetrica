package com.metrica.formacion.apigruposmetrica.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.metrica.formacion")
@ComponentScan("com.metrica.formacion")
@EnableTransactionManagement
@EnableDiscoveryClient
public class SpringConfigurationFile {


}
