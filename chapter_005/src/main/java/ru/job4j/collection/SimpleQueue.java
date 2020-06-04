package ru.job4j.collection;

import java.util.NoSuchElementException;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 04.06.2020
 */
public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack();
    private final SimpleStack<T> out = new SimpleStack();
    private int indexIn = -1;
    private int indexOut = -1;

    public T poll() {
        if (indexIn == -1 && indexOut == -1)
            throw new NoSuchElementException();
        if (indexOut == -1)
            while (indexIn != -1) {
                out.push(in.pop());
                indexOut++;
                indexIn--;
            }
        indexOut--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        indexIn++;
    }
}
