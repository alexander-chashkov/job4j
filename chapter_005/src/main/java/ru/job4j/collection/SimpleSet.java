package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 10.06.2020
 */
public class SimpleSet<E> implements Iterable<E> {
    private SimpleArray<E> sa = new SimpleArray<>();

    void add(E e) {
        boolean addFlag = true;
        for (int i = 0; i <= sa.size(); i++) {
            E elem = sa.get(i);
            if (elem.equals(e)) {
                addFlag = false;
                break;
            }
        }
        if (addFlag)
            sa.add(e);
    }

    @Override
    public Iterator<E> iterator() {
        return sa.iterator();
    }
}

