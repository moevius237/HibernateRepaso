package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ninja")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Override
    public String toString() {
        return "Ninja{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", chakra=" + chakra +
                ", aldea=" + aldea +
                ", mision=" + mision +
                ", rango='" + rango + '\'' +
                '}';
    }

    @Column(name = "nombre",nullable = false,unique = true)
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    @Column(name = "chakra",nullable = false)
    private Double chakra;

    @ManyToOne
    @JoinColumn(name = "aldea_id")
    private Aldea aldea;

    @ManyToOne
    @JoinColumn(name = "mision_id")
    private Mision mision;

    @Column(name = "rango",nullable = false)
    private String rango;

    public Mision getMision() {
        return mision;
    }

    public void setMision(Mision mision) {
        this.mision = mision;
    }

    public Aldea getAldea() {
        return aldea;
    }

    public void setAldea(Aldea aldea) {
        this.aldea = aldea;
    }

    public Double getChakra() {
        return chakra;
    }

    public void setChakra(Double chakra) {
        this.chakra = chakra;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
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
