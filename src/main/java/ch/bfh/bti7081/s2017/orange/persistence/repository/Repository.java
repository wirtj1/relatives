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
 * Abstract class for the generic repository
 */
public abstract class Repository<T extends Identity> {

    private EntityManager em;

    // Sadly java generics are not as powerful as C# generics....
    // Thats why we need the class and the generic type T both :(
    private Class<T> entityClass;

    public Repository(Class<T> entityClass) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orange");
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


    /**
     * usage: findWhere(Car.class, (cb, root) -> (cb.equal(root.get(Car_.colour), colour)));
     * @param pb
     * @return
     */
    public List<T> findWhere(PredicateBuilder<T> pb) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(entityClass);
        Root<T> root = q.from(entityClass);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        CriteriaQuery<T> criteriaQuery = q.select(root);
        criteriaQuery.where(pb.build(cb, root));
        TypedQuery<T> typedQuery = em.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    public interface PredicateBuilder<T> {
        Predicate build(CriteriaBuilder criteriaBuilder, Root<T> root);
    }


    protected EntityManager getEm() {
        return em;
    }


}
