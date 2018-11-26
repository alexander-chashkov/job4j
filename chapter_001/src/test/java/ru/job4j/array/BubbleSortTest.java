package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Тесты Сортировка пузырьком
 * @author Chashkov Alexander
 * @version 0.0.0.1
 * @since 2018.11.26
 */
public class BubbleSortTest {

    /**
     * test 1 for ten elements
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        int[] arr1 = new int[]{1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        BubbleSort bb = new BubbleSort();
        int[] expect = bb.sort(arr1);
        int[] rst = new int[]{0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(rst, is(expect));
    }

    /**
     * test 2 for five elements
     */
    @Test
    public void whenSortArrayWithFiveElementsThenSortedArray() {
        int[] arr1 = new int[]{5, 4, 31, 22, 44};
        BubbleSort bb = new BubbleSort();
        int[] expect = bb.sort(arr1);
        int[] rst = new int[]{4, 5, 22, 31, 44};
        assertThat(rst, is(expect));
    }
}

