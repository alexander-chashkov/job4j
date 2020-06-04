package ru.job4j.collection;

import java.util.Stack;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 04.06.2020
 */
public class SimpleStack<T> {
    private SimpleLinkedList<T> linked = new SimpleLinkedList<T>();
    private int index = -1;

    public T pop() {
        T result = linked.get(index);
        linked.deleteLast();
        index--;
        return result;
    }

    public void push(T value) {
        linked.add(value);
        index++;
    }
}
