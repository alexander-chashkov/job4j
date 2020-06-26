package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 26.06.2020
 */
public interface SimpleTree<E> {
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);

    class Node<E> {
        final E value;
        final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }
    }
}
