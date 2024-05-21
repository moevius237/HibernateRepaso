package org.example.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.example.entity.Aldea;
import org.example.entity.Mision;
import org.example.entity.Ninja;
import org.example.util.HibenateUtil;
import org.hibernate.Session;
import org.hibernate.action.internal.EntityUpdateAction;

import java.util.AbstractList;
import java.util.List;

/**
 * Sasuke uchiha ha decidido abandonar la mision que tiene asignada y su aldea tambien para ser un ninja
 * del mundo independiente. Selecciona al ninja con menos chakra para asignarle su mision
 */
public class NinjasDaoJpa implements NinjasDao{
    public List<Ninja> findJonin(String rango,double recompensa) {
        try (Session session = HibenateUtil.getSessionFactory().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Ninja> criteria = builder.createQuery(Ninja.class);
            Root<Ninja> root = criteria.from(Ninja.class);
            Join<Ninja, Mision> join = root.join("mision");
            criteria.where(
                    builder.and(
                            builder.equal(root.get("rango"),rango),
                            builder.gt(join.get("recompensa"),recompensa)
                    ));
            return session.createQuery(criteria).getResultList();
        }
    }

    @Override
    public Ninja findNinja(String nombre) {
        try (Session session = HibenateUtil.getSessionFactory().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Ninja> criteria = builder.createQuery(Ninja.class);
            Root<Ninja> root = criteria.from(Ninja.class);
            criteria.where(builder.equal(root.get("nombre"),nombre));
            return session.createQuery(criteria).setMaxResults(1).getSingleResultOrNull();
        }
    }

    @Override
    public void ActuazliarNinja(Ninja actualizar) {
        try (Session session = HibenateUtil.getSessionFactory().openSession()){
           session.beginTransaction();
           actualizar.setAldea(null);
           actualizar.setMision(null);
           session.merge(actualizar);
           session.getTransaction().commit();
        }
        /*
        try(Session session = HIbernateUtil.getSessionFactory().opensession()){
           return session.createquety("from ninja where nombre=?")
        }
         */
    }

    @Override
    public Ninja finfNinjaLeastChakra() {
        try (Session session = HibenateUtil.getSessionFactory().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Ninja> criteria = builder.createQuery(Ninja.class);
            Root<Ninja> root = criteria.from(Ninja.class);
            criteria.orderBy(builder.asc(root.get("chakra")));
            return session.createQuery(criteria).setMaxResults(1).getSingleResultOrNull();
        }
    }

    @Override
    public void updateMision(Ninja nuevo, Ninja sasuke) {
        try (Session session = HibenateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            nuevo.setMision(sasuke.getMision());
            session.merge(nuevo);
            session.getTransaction().commit();

        }
    }
}
