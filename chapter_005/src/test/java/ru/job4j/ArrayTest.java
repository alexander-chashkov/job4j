package ru.job4j;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class ArrayTest {
    /**
     * тест матрицы 2 на 2
     *
     */
    @Test
    public void whenArray2x2Then4Elements() {
        int[][] value = {{1, 2}, {3, 4}};
        var ar = new Array(value);
        var result = new StringBuilder();
        while (ar.hasNext()) {
            result.append(ar.next());
        }
        var expected = "1234";
        assertEquals(result.toString(), expected);
    }
    /**
     * тест зазубреный двумерный массив
     */
    @Test
    public void whenJaggedArrayThenCorrect() {
        int[][] value = {{1}, {2, 3, 4, 5, }, {6, 7}, {8, 9, 10, 11, 12, 13, 14}};
        var ar = new Array(value);
        var result = new StringBuilder();
        while (ar.hasNext()) {
            result.append(ar.next());
        }
        var expected = "1234567891011121314";
        assertEquals(result.toString(), expected);
    }

    @Test(expected = NoSuchElementException.class)
    public void testToDoubleException() {
        int[][] value = {{1}};
        var ar = new Array(value);
        int expected = 1;
        int result = (Integer) ar.next();
        assertEquals(result, expected);
        ar.next();
    }
}
