package ru.job4j;

import java.util.*;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2019.04.14
 *
 */
public class SimpleArray<T> implements  Iterable<T> {

    private Object[] elementData;
    private int curIndex = 0;
    private int size;

    public SimpleArray(int size) {
        elementData = new Object[size];
        this.size = size;
    }

    public void add(T model) {
        elementData[curIndex++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, curIndex);
        elementData[index] = model;
    }

    public T get(int index) {
        Objects.checkIndex(index, curIndex);
        return (T) elementData[index];
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
            return cursor != curIndex;
        }


        public T next() {
            int prevCursor = cursor;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            cursor = prevCursor + 1;
            return (T) SimpleArray.this.elementData[prevCursor];
        }
    }




}
