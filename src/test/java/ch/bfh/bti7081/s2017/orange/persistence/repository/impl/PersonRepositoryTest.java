package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Patient;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Leandro on 23/5/2017.
 */
public class PersonRepositoryTest {
    @Test
    public void getPatientsByRelative() throws Exception {

        PersonRepository personRepository = new PersonRepository();
        personRepository.getAll().forEach(System.out::println);
        Relative johny = new Relative("John", "Smith");
        Patient kevin = new Patient("Kevin", "Smith");
        personRepository.persist(johny);
        personRepository.persist(kevin);


        Relative rel = (Relative) personRepository.find(johny.getId()).get();
        Patient patient = (Patient) personRepository.find(kevin.getId()).get();

        patient.addRelative(rel);
        personRepository.persist(patient);

        Patient patientWithRelatives = (Patient) personRepository.find(kevin.getId()).get();

        assertTrue(patientWithRelatives.getRelatives().get(0).getFirstName().equals("John"));
    }

}