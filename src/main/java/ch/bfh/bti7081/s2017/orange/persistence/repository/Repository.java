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

    // Sadly java generics are not as powerful as C# generics....
    // Thats why we need the class and the generic type T both :(
    private Class<T> entityClass;

    public Repository(Class<T> entityClass) {
        emf = Persistence.createEntityManagerFactory("orange");
        em = emf.createEntityManager();
        this.entityClass = entityClass;
    }

    /**
     */
    public T persist(T obj) {
        em.getTransaction().begin();

        if (em.contains(obj)) {
            em.merge(obj);
        }
        else {
            em.persist(obj);
        }

        em.getTransaction().commit();
        return obj;
    }

    public boolean remove(T obj){
        em.getTransaction().begin();

        if (em.contains(obj)){
            em.remove(obj);
            em.getTransaction().commit();
            return true;
        }

        return false;
    }

    public Optional<T> find(long id){
        T obj = em.find(entityClass, id);
        return Optional.ofNullable(obj);
    }

}
