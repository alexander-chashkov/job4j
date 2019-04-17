package ru.job4j;

import java.util.*;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2019.04.14
 *
 */
public class SimpleArray<T> implements  Iterable<T> {

    Object[] elementData;
    int curIndex = 0;
    private int size;

    public SimpleArray(int size) {
        elementData = new Object[size];
        this.size = size;
    }

    public void add(T model) {
        elementData[curIndex++] = model;
    }

    public void set(int index, T model) {
        rangeCheck(index);
        elementData[index] = model;
    }

    public T remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elementData;
        T oldValue = (T) es[index];
        final int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(es, index + 1, es, index, newSize - index);
        }
        size = newSize;
        es[size] = null;
        return oldValue;
    }

    public T get(int index) {
        return (T) elementData[index];
    }

    private void rangeCheck(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("index: " + index + " size: " + this.size);
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        int cursor;
        int lastRet = -1;

        Itr() {
        }

        public boolean hasNext() {
            return cursor != size;
        }


        public T next() {
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            Object[] elementData = SimpleArray.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            cursor = i + 1;
            lastRet = i;
            return (T) elementData[lastRet];
        }

        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            try {
                SimpleArray.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }




}
