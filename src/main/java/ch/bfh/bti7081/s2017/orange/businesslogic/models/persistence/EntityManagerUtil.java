package ch.bfh.bti7081.s2017.orange.businesslogic.models.persistence;

/**
 * Created by Jasmin on 07.05.2017.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerUtil
{
    private static final EntityManagerFactory entityManagerFactory;

    static
    {
        try
        {
            entityManagerFactory = Persistence.createEntityManagerFactory("orange");

        } catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager()
    {
        return entityManagerFactory.createEntityManager();

    }

}
