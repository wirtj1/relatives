package ch.bfh.bti7081.s2017.orange.presentation.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yvesbeutler
 * Unit testing for the functionality of {@link ParameterSet}. These tests are based
 * on the arrange-act-assert pattern.
 */
public class ParameterSetTest {
    @Test
    public void shouldAddParameterToNewSet() throws Exception {

        // arrange
        ParameterSet result = new ParameterSet();
        String expectedResult = "viagra";

        // act
        result.addParameter("medicine", "viagra");

        // assert
        assertTrue(result.getParameter("medicine").equals(expectedResult));
    }

    @Test
    public void shouldAddParameterToExistingSet() throws Exception {

        // arrange
        ParameterSet result = new ParameterSet();
        result.addParameter("medicine", "viagra");
        String expectedResult = "200";

        // act
        result.addParameter("dose", "200");

        // assert
        assertTrue(result.getParameter("dose").equals(expectedResult));
    }

    @Test
    public void shouldReturnNavigationFriendlyString() throws Exception {

        // arrange
        ParameterSet ps = new ParameterSet();
        ps.addParameter("medicine", "viagra");
        ps.addParameter("dose", "200");
        String expectedResult = "dose=200&medicine=viagra";

        // act
        String result = ps.toString();

        // assert
        assertEquals(result, expectedResult);
    }

    @Test
    public void shouldDecodeParameters() throws Exception {

        // arrange
        String encodedString = "medicine=viagra&dose=200";
        String expectedKey1 = "medicine";
        String expectedValue1 = "viagra";
        String expectedKey2 = "dose";
        String expectedValue2 = "200";

        // act
        ParameterSet result = ParameterSet.decode(encodedString);

        // assert
        assertEquals(result.getParameter(expectedKey1), expectedValue1);
        assertEquals(result.getParameter(expectedKey2), expectedValue2);
        assertNotEquals(result.getParameter(expectedKey1), expectedValue2);
    }
}