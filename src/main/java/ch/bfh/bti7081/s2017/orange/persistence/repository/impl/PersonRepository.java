package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Patient;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;
import ch.bfh.bti7081.s2017.orange.persistence.repository.Repository;

import java.util.List;

/**
 * @author yvesbeutler
 * Implementation of the person repository which is used to get, persist,
 * edit or delete persons.
 */
public class PersonRepository extends Repository<Person>
{

    public PersonRepository()
    {
        super(Person.class);
    }

    public List<Patient> getPatientsByRelative(Relative relative)
    {
        return getEm().createQuery("select p from Person p where p.id = :rel").setParameter("rel", relative.getId()).getResultList();
    }


    protected List<Person> getAll()
    {
        return getEm().createQuery("select p from Person p").getResultList();
    }
}
