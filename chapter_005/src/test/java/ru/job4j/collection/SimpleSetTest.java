package ru.job4j.collection;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 10.06.2020
 */
public class SimpleSetTest {
    @Test
    public void whenAddThenIter() {
        SimpleSet<Integer> linked = new SimpleSet<>();
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }


    @Test(expected = NoSuchElementException.class)
    public void whenAddNotUniqueThenIterUnique() {
        SimpleSet<Integer> linked = new SimpleSet<>();
        linked.add(1);
        linked.add(2);
        linked.add(2);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        it.next();
    }

    @Test
    public void whenAddNotUnique9995ThenIter95() {
        SimpleSet<Integer> linked = new SimpleSet<>();
        linked.add(9);
        linked.add(9);
        linked.add(9);
        linked.add(9);
        linked.add(5);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(9));
        assertThat(it.next(), is(5));
    }
}

