package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "miembro")
public class Miembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String rango;

    @ManyToOne
    @JoinColumn(name = "pirata_id")
    private Pirata pirata;

    @ManyToOne
    @JoinColumn(name = "tripulacion_id")
    private Tripulacion tripulacion;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "fruta_del_diablo_id")
    private FrutaDelDiablo frutaDelDiablo;

    public Tripulacion getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(Tripulacion tripulacion) {
        this.tripulacion = tripulacion;
    }

    public FrutaDelDiablo getFrutaDelDiablo() {
        return frutaDelDiablo;
    }

    public void setFrutaDelDiablo(FrutaDelDiablo frutaDelDiablo) {
        this.frutaDelDiablo = frutaDelDiablo;
    }

    public Pirata getPirata() {
        return pirata;
    }

    public void setPirata(Pirata pirata) {
        this.pirata = pirata;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }
}
