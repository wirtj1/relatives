package ch.bfh.bti7081.s2017.orange.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * EntityManagerFactoriy has to be singleton: https://stackoverflow.com/questions/42728479/calling-persistence-createentitymanagerfactory-1-time
 *
 * This class provides EntityManager Instances to all Repositories.
 * @author Leandro on 5/6/2017.
 */
public class EntityManagerFactoryOrange {
    private volatile static EntityManagerFactory factory;

    private static EntityManagerFactory getInstance() {
        if (factory == null) {
            synchronized (EntityManagerFactory.class) {
                if (factory == null) {

                    factory = Persistence.createEntityManagerFactory("orange");
                }
            }
        }
        return factory;
    }

    public static EntityManager getEntityManager()
    {
        return getInstance().createEntityManager();
    }

}
