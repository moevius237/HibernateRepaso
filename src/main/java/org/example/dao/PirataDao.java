package org.example.dao;

import org.example.entity.Miembro;
import org.example.entity.Pirata;
import org.example.entity.Tripulacion;

import java.util.List;

/**
 * Patrón DAO -->Data Acces Object
 */
public interface PirataDao {
    Tripulacion findTripulacionByName(String name);

    List<Miembro> bountyOver100(double recompensa);

    String findBounty(List<Pirata> piratas);

    Pirata findPirata();
    void nuevoCapitan(Pirata pirata, Pirata nuevo);
}
