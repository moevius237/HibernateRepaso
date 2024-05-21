package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mision")
public class Mision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Override
    public String toString() {
        return "Mision{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", recompensa='" + recompensa + '\'' +
                ", rango='" + rango + '\'' +
                '}';
    }

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "recompensa",nullable = false)
    private double recompensa;

    @Column(name = "rango")
    private String rango;

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public double getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(double recompensa) {
        this.recompensa = recompensa;
    }

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
