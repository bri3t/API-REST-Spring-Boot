package com.arnau_briet.gestionanimales.backend.business.model;

import java.io.Serializable;
import java.util.Objects;

public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
    private String especie;
    private Caracteristicas caracteristicas;
    private String estadoConservacion;

    // Constructor vacío
    public Animal() {
    }

    // Constructor con todos los parámetros
    public Animal(Long id, String nombre, String especie, Caracteristicas caracteristicas,
            String estadoConservacion) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.caracteristicas = caracteristicas;
        this.estadoConservacion = estadoConservacion;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Caracteristicas caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getEstadoConservacion() {
        return estadoConservacion;
    }

    public void setEstadoConservacion(String estadoConservacion) {
        this.estadoConservacion = estadoConservacion;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id) &&
                Objects.equals(nombre, animal.nombre) &&
                Objects.equals(especie, animal.especie) &&
                Objects.equals(caracteristicas, animal.caracteristicas) &&
                Objects.equals(estadoConservacion, animal.estadoConservacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, especie, caracteristicas, estadoConservacion);
    }

    // toString
    @Override
    public String toString() {
        return "Animal{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", caracteristicas=" + caracteristicas +
                ", estadoConservacion='" + estadoConservacion + '\'' +
                '}';
    }
}