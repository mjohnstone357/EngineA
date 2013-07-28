package util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Matthew Johnstone
 *         Date: 27/07/13
 *         Time: 15:45
 */
public class ListElementCheckerTest {

    @Test
    public void should_instantiate() {
         new ListElementChecker(); // Just for coverage
    }

    @Test
    public void should_indicate_no_elements_are_null_when_there_are_no_elements_to_check() {
        assertTrue(ListElementChecker.allElementsNonNull(Arrays.asList()));
    }

    @Test
    public void should_indicate_no_elements_are_there_are_three_elements_and_they_are_all_non_null() {

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        assertTrue(ListElementChecker.allElementsNonNull(integers));
    }

    @Test
    public void should_indicate_no_elements_are_are_zero() {

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        assertTrue(ListElementChecker.allNumbersNonNullAndNonZero(integers));
    }
    @Test

    public void should_indicate_an_element_is_zero() {

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(0);
        integers.add(3);

        assertFalse(ListElementChecker.allNumbersNonNullAndNonZero(integers));
    }

    @Test
    public void should_indicate_an_element_is_null() {

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(null);

        assertFalse(ListElementChecker.allNumbersNonNullAndNonZero(integers));
    }

    @Test
    public void should_indicate_no_elements_are_there_are_three_elements_and_one_is_null() {

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(null);
        integers.add(3);

        assertFalse(ListElementChecker.allElementsNonNull(integers));
    }

    @Test
    public void should_indicate_no_elements_are_there_are_three_elements_and_they_are_all_null() {

        List<Integer> integers = new ArrayList<>();
        integers.add(null);
        integers.add(null);
        integers.add(null);

        assertFalse(ListElementChecker.allElementsNonNull(integers));
    }

}
