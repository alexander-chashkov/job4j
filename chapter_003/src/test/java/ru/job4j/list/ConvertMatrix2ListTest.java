package ru.job4j.list;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class ConvertMatrix2ListTest
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.12.19
 */
public class ConvertMatrix2ListTest {

    /**
     * 2x2 array to arraylist 4
     */
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    /**
     * 3x2 array to arraylist 6
     */
    @Test
    public void when3on2ArrayThenList6() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2, 5},
                {3, 4, 6}
        };
        List<Integer> expect = Arrays.asList(1, 2, 5, 3, 4, 6);
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    /**
     * 0x2 array to arraylist 0
     */
    @Test
    public void when0on2ArrayThenList0() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {},
                {}
        };
        List<Integer> expect = Arrays.asList();
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}
