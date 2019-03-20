package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2019.03.20
 * конвертер
 **/
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> cur = it.next();
            @Override
            public boolean hasNext() {
                boolean result = cur.hasNext();
                 while ((!result) && it.hasNext()) {
                    this.cur = it.next();
                    result = this.cur.hasNext();
                }
                return result;
            }
            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return cur.next();
            }
        };
    }
}
