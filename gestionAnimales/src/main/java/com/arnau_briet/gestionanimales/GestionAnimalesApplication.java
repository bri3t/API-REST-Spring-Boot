package com.arnau_briet.gestionanimales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GestionAnimalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionAnimalesApplication.class, args);
	}

}
