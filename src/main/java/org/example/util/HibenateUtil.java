package org.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibenateUtil {

    private static SessionFactory sessionFactory;

    private HibenateUtil(){}

    private static SessionFactory buildSessionFactory() {
        //Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("META-INF/hibernate.cfg.xml").build();

        //meter xml de las entity
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void close() {
        //Closes caches and connections pools
        getSessionFactory().close();
    }
}
