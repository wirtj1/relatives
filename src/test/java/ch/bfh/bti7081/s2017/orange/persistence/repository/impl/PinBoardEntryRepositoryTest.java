package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoardEntry;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author yvesbeutler
 * Unit tests for the pinboard entry repository. These tests are based on the
 * arrange-act-assert pattern.
 */
public class PinBoardEntryRepositoryTest {
    private PinBoardEntryRepository pinBoardEntryRepository;

    @Before
    public void setUp() throws Exception {
        pinBoardEntryRepository = new PinBoardEntryRepository();
    }

    @Test
    public void shouldPersistRandomPinboardEntry() throws Exception {
        // arrange
        String expectedMessage = "some random message";
        String expectedTitle = "generic title 01";
        PinBoardEntry entry = new PinBoardEntry();
        entry.setMessage(expectedMessage);
        entry.setTitle(expectedTitle);

        // act
        long id = pinBoardEntryRepository.persist(entry).getId();
        PinBoardEntry result = pinBoardEntryRepository.find(id).get();

        // assert
        assertNotNull(result);
        assertEquals(result.getTitle(), expectedTitle);
        assertEquals(result.getMessage(), expectedMessage);
    }

}