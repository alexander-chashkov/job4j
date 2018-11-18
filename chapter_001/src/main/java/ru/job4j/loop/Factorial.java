package ru.job4j.loop;
/**
 * Factorial подсчет факториала
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.11.18
 */
public class Factorial {


    /**
     * @param n полож целое
     * @return факториал числа n
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
