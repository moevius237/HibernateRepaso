package org.example.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.example.entity.Miembro;
import org.example.entity.Pirata;
import org.example.entity.Tripulacion;
import org.example.util.HibenateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

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


         Monkey d luffy ha decidido abandoar temporalmente su puesto de capitan para explorar el mundo
         selecciona al pirata con menor recompensa y haz que asuma el rol de capitán temporalmente de sa tripulación
         solo indicar quien es el nuevo capitan

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
    public List<Miembro> bountyOver100(double recompensa) {
        try (Session session = HibenateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Miembro> criteria =builder.createQuery(Miembro.class);
            Root<Miembro> root = criteria.from(Miembro.class);
            Join<Miembro,Pirata> join = root.join("pirata");
            criteria.where(builder.gt(join.get("recompensa"),recompensa));
            return session.createQuery(criteria).getResultList();
        }
    }

    @Override
    public String findBounty(List<Pirata> piratas) {
        return "";
    }


    @Override
    public void newCapitan(Pirata pirata) {
        try (Session session = HibenateUtil.getSessionFactory().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Miembro> criteriaQuery = builder.createQuery(Miembro.class);
            Root<Miembro> root = criteriaQuery.from(Miembro.class);
            Join<Miembro,Pirata> join = root.join("pirata");
        }
    }

    @Override
    public Pirata findPirata() {
        try (Session session = HibenateUtil.getSessionFactory().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Pirata> criteria = builder.createQuery(Pirata.class);
            Root<Pirata> root = criteria.from(Pirata.class);
            criteria.orderBy(builder.asc(root.get("recompensa")));
            return session.createQuery(criteria).setMaxResults(1).getSingleResult();
        }
    }

    @Override
    public void nuevoCapitan(Pirata pirata, Pirata nuevo) {
        try (Session session = HibenateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Tripulacion tripulacion = null;
            tripulacion.setCapitan_id(nuevo);
            session.merge(tripulacion);
            session.getTransaction().commit();
        }
    }

}
