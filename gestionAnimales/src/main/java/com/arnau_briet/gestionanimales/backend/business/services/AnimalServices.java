package com.arnau_briet.gestionanimales.backend.business.services;

import java.util.List;
import java.util.Optional;

import com.arnau_briet.gestionanimales.backend.business.model.Animal;

public interface AnimalServices {
    /**
     * Crea un nuevo animal en el sistema.
     * 
     * @param animal el animal a crear
     * @return el ID del animal creado
     */
    Long create(Animal animal); // C

    /**
     * Lee un animal específico por su ID.
     * 
     * @param id el ID del animal
     * @return un Optional que contiene el animal si existe, o vacío si no existe
     */
    Optional<Animal> read(Long id); // R

    /**
     * Actualiza un animal existente.
     * 
     * Lanza una IllegalStateException si el ID del animal es null o no existe en el
     * sistema.
     * 
     * @param animal el animal a actualizar
     */
    void update(Animal animal); // U

    /**
     * Elimina un animal por su ID.
     * 
     * Lanza una IllegalStateException si no existe el ID en el sistema.
     * 
     * @param id el ID del animal a eliminar
     */
    void delete(Long id); // D

    /**
     * Obtiene todos los animales en el sistema.
     * 
     * @return una lista de todos los animales
     */
    List<Animal> getAll();
}
