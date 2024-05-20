package org.example.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.entity.Ninja;
import org.example.util.HibenateUtil;
import org.hibernate.Session;

import java.util.List;

public class NinjasDaoJpa implements NinjasDao{
    public List<Ninja> findJonin() {
        try (Session session = HibenateUtil.getSessionFactory().openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Ninja> criteria = builder.createQuery(Ninja.class);
            Root<Ninja> root = criteria.from(Ninja.class);
            criteria.where(builder.equal(root.get("rango"),"Jonin"));
            return session.createQuery(criteria).getResultList();
        }
    }
}
