package ru.job4j.loop;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * FactorialTest тестирование
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.11.18
 */
public class FactorialTest {

    /**
     * test factorial
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial fact = new Factorial();
        int result = fact.calc(5);
        assertThat(result, is(120));
    }

    /**
     * test factorial
     */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial fact = new Factorial();
        int result = fact.calc(0);
        assertThat(result, is(1));
    }
}