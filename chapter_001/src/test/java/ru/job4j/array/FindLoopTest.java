package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * class FindLoopTest for test
 * @version 0.0.0.1
 * @author Chashkov Alexander
 * @since 2018.11.24
 */
public class FindLoopTest {

    /**
     * test search number 5
     */
    @Test
    public void whenArrayHasLengh5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    /**
     * test search 44, not found
     */
    @Test
    public void whenArrayHasLengh44ThenMinus1() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3, 7, 9};
        int value = 44;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
