package org.example.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.entity.Pirata;
import org.example.entity.Tripulacion;
import org.example.util.HibenateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class PirataDaoJpa implements PirataDao{

    @Override
    public Tripulacion findTripulacionByName(String name) {
        //HQL
        /**
        try (Sessaion session = (HibenateUtil.getSessionFactory()).openSession()) {
            Query<Tripulacion> query = session.createQuery("FROM Tripulacion Where nombre = ?1",Tripulacion.class);
            query.setParameter(1,name);
            return query.getSingleResult();
        }
         */
        //Criteria
        //Select nombre FROM tripulacion Where id=1
        try (Session session = HibenateUtil.getSessionFactory().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Tripulacion> query = builder.createQuery(Tripulacion.class);
            Root<Tripulacion> root = query.from(Tripulacion.class);
            query.where(builder.equal(root.get("nombre"),name));
            return session.createQuery(query).getSingleResultOrNull();

        }
    }

    @Override
    public Pirata findPirataRecompnesa(int recompensa) {
        try (Session session = HibenateUtil.getSessionFactory().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Pirata> query = builder.createQuery(Pirata.class);
            Root<Pirata> root = query.from(Pirata.class);
            query.where(builder.greaterThan(1000000000,recompensa),);
        }
    }
}
