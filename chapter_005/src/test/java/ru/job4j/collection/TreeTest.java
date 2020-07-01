package ru.job4j.collection;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 26.06.2020
 */

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    @Test
    public void whenBinTreeThenIsBinTreeTrue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.isBinary(), is(true));
        tree.add(1, 4);
        assertThat(tree.isBinary(), is(false));
    }
}