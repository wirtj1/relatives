package ch.bfh.bti7081.s2017.orange.persistence.repository.impl;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Account;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Medication;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yvesbeutler
 * Unit tests for the account repository. These tests are based on the
 * arrange-act-assert pattern.
 */
public class MedicationRepositoryTest {
    private MedicationRepository medicationRepository;

    @Before
    public void setUp() throws Exception {
        medicationRepository = new MedicationRepository(Medication.class);
    }

    @Test
    public void shouldGetAll() throws Exception {
        // arrange
        String expectedUsername = "superprof";
        String expectedPassword = "myPW";

        // act
        Account result = accountRepository.getByNameAndPwd(expectedUsername, expectedPassword);

        // assert
        assertNotNull(result);
        assertEquals(result.getUserName(), expectedUsername);
    }

    @Test
    public void shouldNotGetUserWithShittyPassword() throws Exception {
        // arrange
        String expectedUsername = "superprof";
        String wrongPassword = "scrum4Life";

        // act
        Account result = accountRepository.getByNameAndPwd(expectedUsername, wrongPassword);

        // assert
        assertNull(result);
    }

}