package ru.job4j.lambda;

import org.junit.Test;
import ru.job4j.stream.ArrayUtils;


import java.util.List;

import static org.junit.Assert.assertEquals;



/**
 *  @version 0.0.0.1
 *  @since 2019.03.08
 *  @author Chashkov Alexander
 */
public class ArrayUtilsTest {
    @Test
    public void when12NumberThen364() {
        ArrayUtils arUtils = new ArrayUtils();
        List<Long> al =  List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);
        long result = arUtils.sumSqrEvenNumber(al);
        assertEquals(result, 364);
    }

    @Test
    public void when2NumberThen4() {
        ArrayUtils arUtils = new ArrayUtils();
        List<Long> al =  List.of(1L, 2L);
        long result = arUtils.sumSqrEvenNumber(al);
        assertEquals(result, 4);
    }
}
