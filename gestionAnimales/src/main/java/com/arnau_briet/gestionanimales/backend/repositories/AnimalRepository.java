package com.arnau_briet.gestionanimales.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arnau_briet.gestionanimales.backend.business.model.Animal;
import com.arnau_briet.gestionanimales.backend.business.model.Caracteristicas;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("SELECT a FROM Animal a WHERE a.caracteristicas.habitat = :habitat AND a.caracteristicas.dieta = :dieta AND a.caracteristicas.vidaMedia = :vidaMedia")
    List<Animal> findAnimalesByCaracteristicas(@Param("habitat") String habitat, @Param("dieta") String dieta, @Param("vidaMedia") int vidaMedia);
}
