package ru.job4j.list;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import ru.job4j.list.ConvertList2Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
        ConvertList2Array list = new ConvertList2Array();
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
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), 7);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15},
                {0, 0, 0},
                {0, 0, 0}
        };
        assertThat(result, is(expect));
    }
    /**
     * test 0 el to 0
     */
    @Test
    public void when0ElementsThen0() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(), 7);
        int[][] expect = {{}, {}, {}, {}, {}, {}, {}};
        assertThat(result, is(expect));
    }

    /**
     * convert test
     */
    @Test
    public void convert12and3456Then123456() {
        List list = new ArrayList();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        ConvertList2Array convertList = new ConvertList2Array();
        List<Integer> result = convertList.convert(list);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertTrue(CollectionUtils.isEqualCollection(result, expected));

    }
}
