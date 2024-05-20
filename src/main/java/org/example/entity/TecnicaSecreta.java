package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tecnica_secreta")
public class TecnicaSecreta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "ninja_id",nullable = false,unique = true)
    private Ninja ninja;

    public Ninja getNinja() {
        return ninja;
    }

    public void setNinja(Ninja ninja) {
        this.ninja = ninja;
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
