package ru.job4j.array;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * класс тестов удаления дупликатов в массиве
 * @author Chashkov Alexander
 * @version 0.0.0.1
 * @since 2018.11.27
 */
public class ArrayDuplicateTest {

    /**
     * test 1
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayd = new ArrayDuplicate();
        String[] result = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        result = arrayd.remove(result);
        String[] expect = {"Привет", "Мир", "Супер"};
        assertThat(result, is(expect));
    }

    /**
     * test 2
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate2() {
        ArrayDuplicate arrayd = new ArrayDuplicate();
        String[] result = {"Крокодил", "Мир", "Кот", "Собака", "Кот", "Кот", "Человек", "Крокодил", "Привет"};
        result = arrayd.remove(result);
        String[] expect = {"Крокодил", "Мир", "Кот", "Собака", "Привет", "Человек"};
        assertThat(result, is(expect));
    }
}
