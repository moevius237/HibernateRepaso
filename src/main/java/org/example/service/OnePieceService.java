package org.example.service;

import org.example.dao.PirataDao;
import org.example.dao.PirataDaoJpa;
import org.example.entity.Miembro;
import org.example.entity.Pirata;
import org.example.entity.Tripulacion;

import java.util.List;

public class OnePieceService {
    private PirataDao dao = new PirataDaoJpa();

    public Tripulacion getTripulacionByName(String nombre){
        if (nombre.isEmpty()){
            return dao.findTripulacionByName(nombre);
        }else {
            return null;
        }
    }
    public void getPiratasRecompensa(double recompensa){
        List<Miembro> miembros = dao.bountyOver100(recompensa);
        for (Miembro m : miembros){
            System.out.println(m.getNombre());
            System.out.println(m.getRango());
            System.out.println(m.getPirata().getApodo());
            System.out.println(m.getPirata().getRecompensa());
        }
    }
    public void piratilla(Pirata pirata , Pirata nuevo){
        System.out.println(pirata);
    }
}
