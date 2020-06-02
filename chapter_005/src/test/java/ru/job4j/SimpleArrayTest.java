package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2019.04.17
 *
 */
public class SimpleArrayTest {
    private SimpleArray<String> sa;

    @Before
    public void init() {
        sa = new SimpleArray(5);
        sa.add("1");
        sa.add("2");
        sa.add("3");
        sa.add("4");
        sa.add("5");
    }

    /**
     * тесты итератора
     */
    @Test
    public void whenAddNew5ElemStringThenIter1to5() {
        Iterator it = sa.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        String expected = "12345";
        assertEquals(sb.toString(), expected);
    }

    /**
     * set / get test
     */
    @Test
    public void whenAddNew5ElemStringChange3ElemBy5Then5() {
        sa.set(3, "5");
        String expected = "5";
        assertEquals(sa.get(3), expected);
    }

}
