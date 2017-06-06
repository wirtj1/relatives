package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Leandro on 5/6/2017.
 */
public class PinboardRepositoryTest {
    PinBoard pinBoard;
    PinboardRepository pinboardRepository;
    PinBoardEntryRepository pinBoardEntryRepository;
    PersonRepository personRepository;

    @Before
    public void setUp() throws Exception {
        pinboardRepository = new PinboardRepository();
        pinBoardEntryRepository = new PinBoardEntryRepository();
        personRepository = new PersonRepository();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAll() throws Exception {

    }

    @Test
    public void persist() throws Exception {
        List<Person> all = personRepository.getAll();
        Patient patient = (Patient) all.stream().filter(person -> person.getClass().equals(Patient.class)).findFirst().orElse(null);
        pinBoard = patient.getPinboard();
        PinBoardEntry pinBoardEntry = new PinBoardEntry(Type.ALERT, "Title 1", "Message 1", patient, new Date());
        pinBoardEntryRepository.persist(pinBoardEntry);
        pinBoard.addEntry(new PinBoardEntry(Type.ALERT, "Title 1", "Message 1", patient, new Date()));
        pinboardRepository.persist(pinBoard);
    }

}