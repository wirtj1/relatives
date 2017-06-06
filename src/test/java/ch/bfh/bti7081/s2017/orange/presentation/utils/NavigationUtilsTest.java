package ch.bfh.bti7081.s2017.orange.presentation.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yvesbeutler
 * Unit tests for navigation utils. These tests are based on the
 * arrange-act-assert pattern.
 */
public class NavigationUtilsTest {
    @Test
    public void shouldReturnValidNavigationStringWithParams() throws Exception {

        // arrange
        ParameterSet ps = new ParameterSet();
        ps.addParameter("medicine", "viagra");
        ps.addParameter("dose", "200");
        String name = "med";
        String expectedResult = "med/dose=200&medicine=viagra";

        // act
        String result = NavigationUtils.combineNameAndParams(name, ps);

        // assert
        assertTrue(result.equals(expectedResult));
    }

    @Test
    public void shouldReturnValidNavigationStringWithoutParams() throws Exception {

        // arrange
        String name = "userView";
        String expectedResult = "userView";

        // act
        String result = NavigationUtils.combineNameAndParams(name, null);

        // assert
        assertTrue(result.equals(expectedResult));
    }

}