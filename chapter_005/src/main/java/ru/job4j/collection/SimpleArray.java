package ru.job4j.collection;

import java.util.*;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 03.06.2020
 */

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container;
    private int idx;
    private int capasity;
    private int modCount;

    public T get(int index) {
        Objects.checkIndex(index, idx + 1);
        return (T) container[index];
    }

    public void add(T model) {
        idx++;
        if (idx == capasity) {
            capasity = capasity * 2;
            container = Arrays.copyOf(container, capasity);
        }
        container[idx] = model;
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
        private int idxEl;
        private int modCountWhenCreate;

        @Override
        public boolean hasNext() {
            return idxEl != idx ;
        }

        @Override
        public T next() {
            if (modCount != modCountWhenCreate) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            idxEl++;
            return (T) container[idxEl];
        }

        public SimpleArrayIterator() {
            this.idxEl = -1;
            this.modCountWhenCreate = modCount;
        }
    }

}

