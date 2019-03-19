package ru.job4j;

import java.util.Iterator;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2019.03.18
 * итератор для массива
 */
public class Array implements Iterator {
    private int[][] values;
    private int indexCol = 0;
    private int indexRow = -1;

    public Array(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return this.values.length - 1 >= indexCol + 1 || this.values[indexCol].length - 1 >= indexRow + 1;
    }

    @Override
    public Object next() {
        if (this.values[indexCol].length - 1 == indexRow) {
            indexRow = 0;
            indexCol++;
        } else {
            indexRow++;
        }
        return this.values[indexCol][indexRow];
    }
}
