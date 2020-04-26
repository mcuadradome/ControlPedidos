package com.uniminuto.RegistroVentas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RegistroVentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroVentasApplication.class, args);
	}

}
