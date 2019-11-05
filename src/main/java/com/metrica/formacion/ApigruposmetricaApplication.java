package com.metrica.formacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApigruposmetricaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigruposmetricaApplication.class, args);
	}

}
