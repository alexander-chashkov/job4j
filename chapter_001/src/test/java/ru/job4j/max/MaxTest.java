package ru.job4j.max;


import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Тесты на макс число.
 * MaxTest
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.11.17
 */
public class MaxTest {

    /**
     * test 1 when first number is greater than the second number
     */
    @Test
    public void whenFirstGreaterSecond() {
        Max maxim = new Max();
        int result = maxim.max(10, 4);
        assertThat(result, is(10));
    }


    /**
     * test 1 when first number is greater than the second number
     */
    @Test
    public void whenSecondGreaterFirst() {
        Max maxim = new Max();
        int result = maxim.max(8, 25);
        assertThat(result, is(25));
    }

    /**
     * test max(?, ?, ?)
     */
    @Test
    public void max() {
        Max maxim = new Max();
        int result = maxim.max(21, 44, 95);
        assertThat(result, is(95));
    }
}
