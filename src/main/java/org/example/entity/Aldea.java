package org.example.entity;

import jakarta.persistence.*;

/**
 * Encuentra los ninjas con rango "Jonin" que tienen una misiñon con una recompensa a 9999
 * muestra sus bombres , aldea  , rango , nombre misión y rango misión
 * */
@Table
@Entity(name = "aldea")
public class Aldea {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
