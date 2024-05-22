package com.arnau_briet.gestionanimales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.arnau_briet.gestionanimales.backend.repositories")
public class GestionAnimalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionAnimalesApplication.class, args);
    }
}
