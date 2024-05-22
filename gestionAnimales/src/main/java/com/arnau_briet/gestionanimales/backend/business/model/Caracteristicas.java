package com.arnau_briet.gestionanimales.backend.business.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "caracteristicas")
public class Caracteristicas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "habitat")
    private String habitat;

    @Column(name = "dieta")
    private String dieta;

    @Column(name = "vida_media")
    private int vidaMedia;

    // Constructor vacío
    public Caracteristicas() {
    }

    // Constructor con todos los parámetros
    public Caracteristicas(String habitat, String dieta, int vidaMedia) {
        this.habitat = habitat;
        this.dieta = dieta;
        this.vidaMedia = vidaMedia;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public int getVidaMedia() {
        return vidaMedia;
    }

    public void setVidaMedia(int vidaMedia) {
        this.vidaMedia = vidaMedia;
    }

    // equals, hashCode and toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caracteristicas that = (Caracteristicas) o;
        return vidaMedia == that.vidaMedia &&
               Objects.equals(habitat, that.habitat) &&
               Objects.equals(dieta, that.dieta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(habitat, dieta, vidaMedia);
    }

    @Override
    public String toString() {
        return "Caracteristicas{" +
               "habitat='" + habitat + '\'' +
               ", dieta='" + dieta + '\'' +
               ", vidaMedia=" + vidaMedia +
               '}';
    }
}
