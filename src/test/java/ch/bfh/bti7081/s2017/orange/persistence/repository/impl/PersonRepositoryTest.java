package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Leandro on 23/5/2017.
 */
public class PersonRepositoryTest {
    PersonRepository personRepository;

    @Before
    public void prepare()
    {
        personRepository = new PersonRepository();
    }


    @Test
    public void getPatientsByRelative() throws Exception {

    }

    @Test
    public void getAll() throws Exception {
        List<Person> persons = personRepository.getAll();
    }

    @Test
    public void saveRelative()
    {
        Relative r = new Relative("John", "Smith");
        personRepository.persist(r);

    }

}