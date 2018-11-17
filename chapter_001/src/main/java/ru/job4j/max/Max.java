package ru.job4j.max;
/**
 *
 * Класс для нахождения макс из чисел.
 * Max
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.11.17
 */


public class Max {

    /**
     * constr
     */
    public Max() {

    }
    /**
     * @param first number 1
     * @param second number 2
     * @return maximum of numbers 1, 2
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
