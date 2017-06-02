package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.*;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Leandro on 23/5/2017.
 */
public class PersonRepositoryTest {
    @Test
    public void getPatientsByRelative() throws Exception {

        PersonRepository personRepository = new PersonRepository();
        personRepository.getAll().forEach(System.out::println);

        PinboardRepository pinboardRepository = new PinboardRepository();
        PinBoardEntryRepository pinBoardEntryRepository = new PinBoardEntryRepository();

        Relative johny = new Relative("John", "Smith");
        Patient kevin = new Patient("Kevin", "Smith");

        personRepository.persist(johny);

        PinBoard pinBoard = new PinBoard();

        PinBoardEntry entry = new PinBoardEntry(Type.ALERT, "Hello world", "Hello world", johny, new Date());
        pinBoard.addEntry(entry);
        pinBoardEntryRepository.persist(entry);



        personRepository.persist(kevin);
        //kevin.setPinBoard(pinBoard);

        pinboardRepository.persist(pinBoard);

        Relative rel = (Relative) personRepository.find(johny.getId()).get();
        Patient patient = (Patient) personRepository.find(kevin.getId()).get();


        patient.addRelative(rel);
        personRepository.persist(patient);


        Patient patientWithRelatives = (Patient) personRepository.find(kevin.getId()).get();

        assertTrue(patientWithRelatives.getRelatives().get(0).getFirstName().equals("John"));
    }

}