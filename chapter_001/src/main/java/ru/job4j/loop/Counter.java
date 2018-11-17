package ru.job4j.loop;
/**
 * Counter
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.11.17
 */


public class Counter {
    public Counter() {
    }
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
