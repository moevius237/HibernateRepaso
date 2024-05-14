package org.example.service;

import org.example.dao.PirataDao;
import org.example.dao.PirataDaoJpa;
import org.example.entity.Tripulacion;

public class OnePieceService {
    private PirataDao dao = new PirataDaoJpa();

    public Tripulacion getTripulacionByName(String nombre){
        if (nombre.isEmpty()){
            return dao.findTripulacionByName(nombre);
        }else {
            return null;
        }
    }
}
