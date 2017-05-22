package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Identity;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;
import ch.bfh.bti7081.s2017.orange.repository.EntityManagerUtil;
import ch.bfh.bti7081.s2017.orange.persistence.repository.Repository;

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
public class PersonRepository implements Repository
{

  private EntityManager entityManager = EntityManagerUtil.getEntityManager();

  /**
   * Returns a person matching with the given id. To prevent {@link NullPointerException}
   * an Optional is used.
   */
  @Override public Optional get(long id)
  {
    Optional<Person> optPerson = Optional.empty();
    try
    {
      transactionBegin(entityManager);
      optPerson = Optional.of(entityManager.find(Person.class, id));
      transactionCommit(entityManager);
    }
    catch (Exception e)
    {
      transactionRollback(entityManager);
    }
    return optPerson;
  }

  /**
   * not implemented yet.
   */
  @Override public List get(Predicate predicate)
  {
    return null;
  }

  /**
   * Returns a list of {@link Person}.
   */
  @Override public List<Person> get()
  {
    List<Person> persons = new ArrayList<>();
    try
    {
      transactionBegin(entityManager);
      persons = entityManager.createQuery("from USER").getResultList();
      transactionCommit(entityManager);
    }
    catch (Exception e)
    {
      transactionRollback(entityManager);
    }
    return persons;
  }

  /**
   * Inserts a {@link Person} into the database.
   */
  @Override public Person add(Identity entity)
  {
    Person person = new Relative();
    try
    {
      transactionBegin(entityManager);
      person = (Person)entity;
      entityManager.merge(person);
      transactionCommit(entityManager);
    }
    catch (Exception e)
    {
      transactionRollback(entityManager);
    }
    return person;
  }

  /**
   * Updates existing {@link Person} in the database.
   */
  @Override public Person edit(Identity entity)
  {
    Person person = new Relative();
    try
    {
      transactionBegin(entityManager);
      person = entityManager.find(Person.class, entity.getId());
      // TODO: define how to merge person
      person = (Person)entity;
      entityManager.merge(person);
      transactionCommit(entityManager);
    }
    catch (Exception e)
    {
      transactionRollback(entityManager);
    }
    return person;
  }

  /**
   * Removes existing {@link Person} from the database.
   */
  @Override public void delete(Identity entity)
  {
    try
    {
      transactionBegin(entityManager);
      Person person = entityManager.find(Person.class, entity.getId());
      entityManager.remove(person);
      transactionCommit(entityManager);
    }
    catch (Exception e)
    {
      transactionRollback(entityManager);
    }
  }
}
