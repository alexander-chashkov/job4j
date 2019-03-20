package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2019.03.19
 *  итератор возвращающий только четные цифры.
 */
public class EvenIt implements Iterator {
    private int[] array;
    private int idx;
    private int nextIdx;
    public EvenIt(final int[] numbers) {
        this.array = numbers;
        this.idx = -1;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        var i = idx + 1;
        while (i < this.array.length) {
            if (this.array[i] % 2 == 0) {
                result = true;
                nextIdx = i;
                break;
            }
            i++;
        }
        return result;
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.idx = this.nextIdx;
        return this.array[idx];
    }
}
