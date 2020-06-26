package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 26.06.2020
 */
public class HashMapSimpleTest {
    @Test
    public void whenAddThenGet() {
        HashMapSimple<String, String> map = new HashMapSimple<>();
        map.insert("1", "1");
        map.insert("2", "2");
        map.insert("3", "3");
        map.insert("4", "4");
        map.insert("5", "5");
        map.insert("6", "6");
        map.insert("7", "7");
        map.insert("8", "8");
        map.insert("9", "9");
        map.insert("10", "10");
        map.insert("10", "12");
        map.insert("1a1", "11a");
        map.insert("11b", "11b");
        map.insert("11c", "11c");
        map.insert("11d", "11d");
        map.insert("1a11", "11a1");
        map.insert("11b1", "11b1");
        map.insert("11c1", "11c1");
        map.insert("11d1", "11d1");
        String rsl = map.get("7");
        assertThat(rsl, is("7"));
        rsl = map.get("10");
        assertThat(rsl, is("12"));
        map.delete("8");
        rsl = map.get("8");
        assertNull(rsl);
    }

    @Test
    public void whenAddThenIterator() {
        HashMapSimple<String, String> map = new HashMapSimple<>();
        map.insert("1", "1");
        map.insert("2", "2");
        map.insert("3", "3");
        map.insert("4", "4");
        map.insert("5", "5");
        map.insert("6", "6");
        map.insert("7", "7");
        map.insert("8", "8");
        map.insert("9", "9");
        map.insert("10", "10");
        map.insert("10", "12");
        map.insert("1a1", "11a");
        map.insert("11b", "11b");
        map.insert("11c", "11c");
        map.insert("11d", "11d");
        map.insert("1a11", "11a1");
        map.insert("11b1", "11b1");
        map.insert("11c1", "11c1");
        map.insert("11d1", "11d1");
        map.insert("11d1", "11d1");
        map.insert("11d1", "11d1");
        map.insert("11d1", "11d1");
        map.insert("11d1", "11d1");
        map.insert("11d1", "11d1");
        map.insert("11d1", "11d1");
        Iterator it = map.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            System.out.println(str);
            i++;
        }
        assertThat(i, is(18));
    }
}
