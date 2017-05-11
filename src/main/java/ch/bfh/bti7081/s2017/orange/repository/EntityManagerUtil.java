package ch.bfh.bti7081.s2017.orange.repository;

/**
 * Created by Jasmin on 07.05.2017.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    /**
     * this factory class supports instantiation of EntityManager instances
     * EntityManagerFactory itself has to get instantiated only once
     */
    private static final EntityManagerFactory entityManagerFactory;


    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("orange");

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    /**
     * EntityManager instance represents the connection to a database.
     * This object will also provide functionality for performing operations on the database
     *
     * @return EntityManager instance
     */
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();

    }


    /**
     * TODO use before application ends
     * <p>
     * Database file will get closed after closing entityManagerFactory
     *
     * @param ems - one or more EntityManager instances to close
     */
    public static void closeConnection(EntityManager... ems) {
        for (EntityManager em : ems)
            em.close();

        entityManagerFactory.close();
    }

}
