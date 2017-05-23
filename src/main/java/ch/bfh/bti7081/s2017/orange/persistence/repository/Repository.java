package ch.bfh.bti7081.s2017.orange.persistence.repository;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Identity;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author yvesbeutler
 * Abstract class for the generic repository
 */
public abstract class Repository<T extends Identity> {

    private EntityManager em;
    private EntityManagerFactory emf;

    public Repository() {
        emf = Persistence.createEntityManagerFactory("orange");
        em = emf.createEntityManager();
    }

    /**
     */
    public T persist(T obj) {
        em.getTransaction().begin();
        try {

            Class<T> myClass = (Class<T>) obj.getClass();

            em.find(myClass, obj);
            em.persist(obj);

        } catch (EntityExistsException eee) {
//            em.getTransaction().
        }
        return null;
    }

}
