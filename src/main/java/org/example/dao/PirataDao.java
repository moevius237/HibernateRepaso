package org.example.dao;

import org.example.entity.Pirata;
import org.example.entity.Tripulacion;

/**
 * Patrón DAO -->Data Acces Object
 */
public interface PirataDao {
    Tripulacion findTripulacionByName(String name);

    Pirata findPirataRecompnesa(int recompensa);

}
