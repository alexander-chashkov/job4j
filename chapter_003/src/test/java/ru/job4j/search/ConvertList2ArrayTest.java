package ru.job4j.search;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * class ConvertList2ArrayTest
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.12.19
 */
public class ConvertList2ArrayTest {
    /**
     * test 7 el to 9
     */
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array(0);
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    /**
     * test 15 el to 21
     */
    @Test
    public void when15ElementsThen21() {
        ConvertList2Array list = new ConvertList2Array(99);
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), 7);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15},
                {99, 99, 99},
                {99, 99, 99}
        };
        assertThat(result, is(expect));
    }
    /**
     * test 0 el to 0
     */
    @Test
    public void when0ElementsThen0() {
        ConvertList2Array list = new ConvertList2Array(99);
        int[][] result = list.toArray(Arrays.asList(), 7);
        int[][] expect = {{}, {}, {}, {}, {}, {}, {}};
        assertThat(result, is(expect));
    }
}
