package com.arnau_briet.gestionanimales.backend.presentation.restcontrollers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.arnau_briet.gestionanimales.backend.business.model.Animal;
import com.arnau_briet.gestionanimales.backend.business.services.AnimalServices;
import com.arnau_briet.gestionanimales.backend.presentation.config.RespuestaError;

@RestController
@RequestMapping("/animales")
public class AnimalController {

    @Autowired
    private AnimalServices animalServices;

    @GetMapping("/todos")
    public List<Animal> getAllAnimals() {
        return animalServices.getAll();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> getAnimalById(@PathVariable Long id) {
        Optional<Animal> optional = animalServices.read(id);
        if (optional.isPresent()) {
            RespuestaError respuestaError = new RespuestaError("No se encuentra el animal con ID " + id);
            return new ResponseEntity<>(respuestaError, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(optional.get());
    }

    @PostMapping("/crear")
    public ResponseEntity<?> createAnimal(@RequestBody Animal animal, UriComponentsBuilder ucb) {
        Long id;
        try {
            id = animalServices.create(animal);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e.getMessage());
        }
        URI uri = ucb.path("/animales/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnimal(@PathVariable Long id) {
        try {
            animalServices.delete(id);
        } catch (IllegalStateException e) {
            throw new RuntimeException("No se encuentra el animal con ID " + id + ". No se ha podido eliminar.");
        }
    }

    @PutMapping("/actualizar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAnimal(@RequestBody Animal animal) {
        try {
            animalServices.update(animal);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    // ****************************************************
    //
    // Gestión de excepciones
    //
    // ****************************************************

    @ExceptionHandler({ IllegalArgumentException.class, ClassCastException.class })
    public ResponseEntity<?> errorHandler1(Exception e) {
        return ResponseEntity.badRequest().body(new RespuestaError(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> errorHandler2(Exception e) {
        return ResponseEntity.badRequest().body(new RespuestaError(e.getMessage()));
    }

}