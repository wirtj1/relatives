package ch.bfh.bti7081.s2017.orange.repository;

import ch.bfh.bti7081.s2017.orange.Identity;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author yvesbeutler
 * Interface for the generic repository
 */
public interface Repository<T extends Identity> {

    default void transactionBegin(EntityManager em) {
        em.getTransaction().begin();
    }

    default void transactionCommit(EntityManager em) {
        em.getTransaction().commit();
    }

    default void transactionRollback(EntityManager em) {
        em.getTransaction().rollback();
    }

    /**
     * return the entity with the given id.
     */
    default Optional<T> get(String id) {
        return get()
                .stream()
                .filter(entity -> entity.getId().equals(id))
                .findAny();
    }

    /**
     * return all entities that match with the given predicate.
     */
    default List<T> get(Predicate<T> predicate) {
        return get()
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    /**
     * return all entities
     */
    List<T> get();

    /**
     * persists the given entity
     */
    T add(T entity);

    /**
     * persists the given entity
     */
    T edit(T entity);

    /**
     * deletes the given entity
     */
    void delete(T entity);

}
