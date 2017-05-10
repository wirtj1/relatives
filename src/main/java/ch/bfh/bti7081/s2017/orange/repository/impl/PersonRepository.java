package ch.bfh.bti7081.s2017.orange.repository.impl;

import ch.bfh.bti7081.s2017.orange.Identity;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.Person;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.persistence.EntityManagerUtil;
import ch.bfh.bti7081.s2017.orange.repository.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author yvesbeutler
 * Implementation of the person repository which is used to get, persist,
 * edit or delete persons.
 */
public class PersonRepository implements Repository {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public Optional get(String id) {
        Optional<Person> optPerson = Optional.empty();
        try {
            transactionBegin(entityManager);
            optPerson = Optional.of(entityManager.find(Person.class, id));
            transactionCommit(entityManager);
        } catch (Exception e) {
            transactionRollback(entityManager);
        }
        return optPerson;
    }

    @Override
    public List get(Predicate predicate) {
        return null;
    }

    @Override
    public List<Person> get() {
        List<Person> persons = new ArrayList<>();
        try {
            transactionBegin(entityManager);
            persons = entityManager.createQuery("from USER").getResultList();
            transactionCommit(entityManager);
        } catch (Exception e) {
            transactionRollback(entityManager);
        }
        return persons;
    }

    @Override
    public Person add(Identity entity) {
        Person person = new Person();
        try {
            transactionBegin(entityManager);
            person = (Person) entity;
            entityManager.merge(person);
            transactionCommit(entityManager);
        } catch (Exception e) {
            transactionRollback(entityManager);
        }
        return person;
    }

    @Override
    public Person edit(Identity entity) {
        Person person = new Person();
        try {
            transactionBegin(entityManager);
            person = entityManager.find(Person.class, entity.getId());
            // TODO: define how to merge person
            person = (Person) entity;
            entityManager.merge(person);
            transactionCommit(entityManager);
        } catch (Exception e) {
            transactionRollback(entityManager);
        }
        return person;
    }

    @Override
    public void delete(Identity entity) {
        try {
            transactionBegin(entityManager);
            Person person = entityManager.find(Person.class, entity.getId());
            entityManager.remove(person);
            transactionCommit(entityManager);
        } catch (Exception e) {
            transactionRollback(entityManager);
        }
    }
}
