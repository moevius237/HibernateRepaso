package org.example.dao;

import org.example.entity.Ninja;

import java.util.List;

public interface NinjasDao {

    List<Ninja> findJonin(String rango,double recompensa);

    Ninja findNinja(String nombre);
    void ActuazliarNinja(Ninja actualizar);
    Ninja finfNinjaLeastChakra();
    void updateMision(Ninja nuevo,Ninja sasuke);
}
