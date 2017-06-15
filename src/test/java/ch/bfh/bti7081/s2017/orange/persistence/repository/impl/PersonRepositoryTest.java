package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    // TODO: check if this repository is used by someone

    @Test
    public void getPatientsByExistingRelative() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
        List<Person> persons = personRepository.getAll();

        List<List<Patient>> patients = persons.stream()
                                        .filter(person -> person.getClass().equals(Relative.class))
                                        .map(relative -> personRepository.getPatientsByRelative((Relative) relative))
                                        .collect(Collectors.toList());

        System.out.println(patients.size());
        for (List<Patient> patient : patients) {
            for (Patient patient1 : patient) {
                System.out.println(patient1.getFirstName());
            }
        }
    }

    @Test
    public void saveRelative()
    {
        Relative r = new Relative("John", "Smith");
        personRepository.persist(r);

    }

}