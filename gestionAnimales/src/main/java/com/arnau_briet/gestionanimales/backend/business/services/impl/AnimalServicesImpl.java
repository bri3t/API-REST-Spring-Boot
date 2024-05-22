package com.arnau_briet.gestionanimales.backend.business.services.impl;

import com.arnau_briet.gestionanimales.backend.business.model.Animal;
import com.arnau_briet.gestionanimales.backend.business.model.Caracteristicas;
import com.arnau_briet.gestionanimales.backend.business.services.AnimalServices;
import com.arnau_briet.gestionanimales.backend.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServicesImpl implements AnimalServices {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    @Transactional
    public Long create(Animal animal) {
        if (animal.getId() != null) {
            throw new IllegalStateException("No se puede crear un animal con ID no nulo");
        }
        Animal savedAnimal = animalRepository.save(animal);
        return savedAnimal.getId();
    }

    @Override
    public Optional<Animal> read(Long id) {
        return animalRepository.findById(id);
    }

    @Override
    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Animal animal) {
        if (animal.getId() == null || !animalRepository.existsById(animal.getId())) {
            throw new IllegalStateException("El animal con ID " + animal.getId() + " no existe. No se puede actualizar.");
        }
        animalRepository.save(animal);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new IllegalStateException("El animal con ID " + id + " no existe. No se puede eliminar.");
        }
        animalRepository.deleteById(id);
    }

    public List<Animal> findAnimalesByCaracteristicas(Caracteristicas caracteristicas) {
        return animalRepository.findAnimalesByCaracteristicas(caracteristicas.getHabitat(), caracteristicas.getDieta(), caracteristicas.getVidaMedia());
    }
}
