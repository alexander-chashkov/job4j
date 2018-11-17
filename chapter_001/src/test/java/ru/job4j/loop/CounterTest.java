package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Тесты на сумму четных чисел
 * CounterTest
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.11.17
 */
public class CounterTest {


    /**
     * test 1..10
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        assertThat(result, is(30));
    }

}
