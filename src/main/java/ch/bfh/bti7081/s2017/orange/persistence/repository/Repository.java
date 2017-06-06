package ch.bfh.bti7081.s2017.orange.persistence.repository;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Identity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

/**
 * @author yvesbeutler
 * Abstract class for the generic repository which provides CRUD functionality.
 */
public abstract class Repository<T extends Identity> {

    private EntityManager em;

    // Sadly java generics are not as powerful as C# generics....
    // Thats why we need the class and the generic type T both :(
    private Class<T> entityClass;

    public Repository(Class<T> entityClass) {
        em = EntityManagerFactoryOrange.getEntityManager();
        this.entityClass = entityClass;
    }

    /**
     * Persists a given object in the database.
     * @param obj Subtype of {@link Identity}
     * @return obj Persisted object
     */
    public T persist(T obj) {
        em.getTransaction().begin();

        if (obj.getId() > 0 ) {
            em.merge(obj);
        }
        else {
            em.persist(obj);
        }

        em.getTransaction().commit();
        return obj;
    }

    /**
     * Removes a given object from the database.
     * @param obj Subtype of {@link Identity}
     * @return true if successfully removed
     */
    public boolean remove(T obj){
        em.getTransaction().begin();

        if (em.contains(obj)){
            em.remove(obj);
            em.getTransaction().commit();
            return true;
        }

        return false;
    }

    /**
     * Finds an object by its ID in the database.
     * @param id the ID used by the database
     * @return Optional to prevent {@link NullPointerException}
     */
    public Optional<T> find(long id){
        T obj = em.find(entityClass, id);
        return Optional.ofNullable(obj);
    }


    /**
     * Finds all objects of a certain type which match with the given predicate.
     * @param pb predicateBuilder
     * @return List of found objects
     */
    public List<T> findWhere(PredicateBuilder<T> pb) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(entityClass);
        Root<T> root = q.from(entityClass);
        CriteriaQuery<T> criteriaQuery = q.select(root);
        criteriaQuery.where(pb.build(cb, root));
        TypedQuery<T> typedQuery = em.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    /**
     * Provides the basic function of the predicate builder
     */
    public interface PredicateBuilder<T> {
        Predicate build(CriteriaBuilder criteriaBuilder, Root<T> root);
    }

    /**
     * Returns the entity manager instance.
     */
    protected EntityManager getEm() {
        return em;
    }


}
