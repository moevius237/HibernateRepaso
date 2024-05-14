package org.example.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@Table(name = "tripulacion")
public class Tripulacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Override
    public String toString() {
        return "Tripulacion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", capitan_id=" + capitan_id +
                '}';
    }

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "capitan_id",nullable = false)
    private Pirata capitan_id;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pirata getCapitan_id() {
        return capitan_id;
    }

    public void setCapitan_id(Pirata capitan_id) {
        this.capitan_id = capitan_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
