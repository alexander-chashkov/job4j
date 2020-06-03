package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 03.06.2020
 */

public class SimpleArray <T> implements Iterable<T> {
    private Object[] container;
    private int idx;
    private int capasity;
    private int modCount;

    public T get(int index) {
        Objects.checkIndex(index, idx + 1);
        return (T) container[index];
    }

    public void add(T model) {
        container[++idx] = model;
        modCount++;
    }

    public SimpleArray() {
        this(10);
    }

    public SimpleArray(int capacity) {
        this.container = new Object[capacity];
        this.idx = -1;
        this.capasity = capacity;
        this.modCount = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator();
    }

    class SimpleArrayIterator implements Iterator<T> {
        private T nextElement;
        private int idxEl;
        private int modCountWhenCreate;

        @Override
        public boolean hasNext() {
            return nextElement != null;
        }

        @Override
        public T next() {
            if (modCount != modCountWhenCreate)
                throw new ConcurrentModificationException();
            idxEl++;
            T result = nextElement;
            Objects.checkIndex(idxEl, container.length);
            nextElement = (T) container[idxEl];
            if (result == null)
                    throw new NoSuchElementException();
            return result;
        }

        public SimpleArrayIterator() {
            this.idxEl = -1;
            this.nextElement = (T) container[0];
            this.modCountWhenCreate = modCount;
        }
    }

}

