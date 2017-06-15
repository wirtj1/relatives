package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoard;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoardEntry;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Professional;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author yvesbeutler
 * Unit tests for the pinboard repository. These tests are based on the
 * arrange-act-assert pattern.
 */
public class PinboardRepositoryTest {
    private PinboardRepository pinboardRepository;
    private PersonRepository personRepository;

    @Before
    public void setUp() throws Exception {
        pinboardRepository = new PinboardRepository();
        personRepository = new PersonRepository();
    }

    @Test
    public void getAllTest()
    {
        List<PinBoard> all = pinboardRepository.getAll();
    }

    @Test
    public void shouldPersistPinboard() throws Exception {
        // arrange
        List<PinBoardEntry> entries = new ArrayList<>();
        PinBoardEntry entry1 = new PinBoardEntry();
        Professional author1 = (Professional) personRepository.find(30).get();
        entry1.setAuthor(author1);
        entry1.setTitle("Patient geflohen");
        entry1.setMessage("Bitte helfen Sie mir, Ihren Opa zu finden");
        entries.add(entry1);

        PinBoardEntry entry2 = new PinBoardEntry();
        Relative author2 = (Relative) personRepository.find(40).get();
        entry2.setAuthor(author2);
        entry2.setTitle("Keine Panik");
        entry2.setMessage("Der ist schon so alt, der wird nicht weit kommen.");
        entries.add(entry2);

        PinBoard pinBoard = new PinBoard();
        pinBoard.setEntries(entries);

        // act
        PinBoard result = pinboardRepository.persist(pinBoard);

        // assert
        assertEquals(result.getEntries().size(), 2);
        assertEquals(result.getEntries().get(0).getAuthor(), author1);
        assertEquals(result.getEntries().get(0).getTitle(), "Patient geflohen");
        assertEquals(result.getEntries().get(1).getAuthor(), author2);
        assertEquals(result.getEntries().get(1).getTitle(), "Keine Panik");
    }

    @Test
    public void shouldPersistPinboard2() throws Exception
    {

        Relative author2 = (Relative) personRepository.find(40).get();
        PinBoardEntry entry2 = new PinBoardEntry(Type.ALERT,
                "Keine Panik",
                "Der ist schon so alt, der wird nicht weit kommen.",
                author2,
                new Date());


        PinBoard pinBoard = new PinBoard();
        pinBoard.addEntry(entry2);

        // act
        PinBoard result = pinboardRepository.persist(pinBoard);

        // assert
        assertEquals(result.getEntries().size(), 1);
        assertEquals(result.getEntries().get(0).getAuthor(), author2);
        assertEquals(result.getEntries().get(0).getTitle(), "Keine Panik");
    }


    @Test
    public void getPinboard() throws Exception
    {

        PinboardRepository pinboardRepository = new PinboardRepository();
        List<PinBoard> all = pinboardRepository.getAll();
        System.out.println();

    }
}