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
    private int indexRow = 0;
    private int size;
    private int idx = 0;

    public Array(int[][] values) {
        this.size = 0;
        this.values = values;
        for (var tmp : this.values) {
            this.size = this.size + tmp.length;
        }
    }

    @Override
    public boolean hasNext() {
        return this.idx < this.size;
    }

    @Override
    public Object next() {
        var result = this.values[indexCol][indexRow];
        this.idx++;
        if (this.values[indexCol].length - 1 == indexRow) {
            indexRow = 0;
            indexCol++;
        } else {
            indexRow++;
        }
        return result;
    }
}
