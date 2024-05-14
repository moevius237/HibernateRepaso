package org.example.entity;

import jakarta.persistence.*;

@Table (name = "pirata")
@Entity
public class Pirata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "apodo", nullable = false ,unique = true)
    private String apodo;

    @Column(name = "recompensa",nullable = false)
    private double recompensa;

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public double getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(double recompensa) {
        this.recompensa = recompensa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
