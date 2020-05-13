package com.registroventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RegistroVentasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroVentasApiApplication.class, args);
	}

}
