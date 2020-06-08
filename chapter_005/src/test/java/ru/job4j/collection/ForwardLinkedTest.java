package ru.job4j.collection;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Iterator;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 08.06.2020
 */

public class ForwardLinkedTest {

    @Test
    public void whenAddThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenAddAndRevertThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenAdd10ElAndRevertThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        for (int i = 0; i < 10; i++ ) {
            linked.add(i);
        }
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(9));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(0));
    }
}
