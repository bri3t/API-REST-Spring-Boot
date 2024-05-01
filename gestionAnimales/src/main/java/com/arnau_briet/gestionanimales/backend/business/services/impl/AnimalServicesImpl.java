package com.arnau_briet.gestionanimales.backend.business.services.impl;

import com.arnau_briet.gestionanimales.backend.business.model.Animal;
import com.arnau_briet.gestionanimales.backend.business.services.AnimalServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AnimalServicesImpl implements AnimalServices {
    private final ConcurrentSkipListMap<Long, Animal> animales = new ConcurrentSkipListMap<>();
    private final AtomicLong idCounter = new AtomicLong(0);  // More thread-safe and explicit ID handling

    public AnimalServicesImpl() {
        init();  // Pre-populate some animals
    }

    @Override
    public Long create(Animal animal) {
        long id = idCounter.incrementAndGet();  // Ensure unique ID generation
        animal.setId(id);
        animales.put(id, animal);
        return id;
    }

    @Override
    public Optional<Animal> read(Long id) {
        return Optional.ofNullable(animales.get(id));
    }

    @Override
    public List<Animal> getAll() {
        return new ArrayList<>(animales.values());
    }

    @Override
    public void update(Animal animal) {
        if (animal.getId() == null || !animales.containsKey(animal.getId())) {
            throw new IllegalStateException("El animal con ID " + animal.getId() + " no existe. No se puede actualizar.");
        }
        animales.put(animal.getId(), animal);
    }

    @Override
    public void delete(Long id) {
        if (!animales.containsKey(id)) {
            throw new IllegalStateException("El animal con ID " + id + " no existe. No se puede eliminar.");
        }
        animales.remove(id);
    }

    private void init() {
        // Initializing with some pre-defined animals
        Animal a1 = new Animal(1L, "León", "Panthera leo", null, "Vulnerable");
        Animal a2 = new Animal(2L, "Elefante", "Loxodonta africana", null, "En peligro");
        Animal a3 = new Animal(3L, "Tortuga Galápagos", "Chelonoidis nigra", null, "Vulnerable");

        animales.put(a1.getId(), a1);
        animales.put(a2.getId(), a2);
        animales.put(a3.getId(), a3);
    }
}
