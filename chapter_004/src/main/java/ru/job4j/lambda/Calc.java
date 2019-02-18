package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2019.02.18
 * подсчет функций в диапазоне
 */
public class Calc {
    /**
     * @param start начало диапазона
     * @param end конец диапазона
     * @param func функция подсчета
     * @return значения функций
     */
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> res = new ArrayList<>();
        for (double i = start; i < end; i++) {
            res.add(func.apply(i));
        }
        return res;
    }
}
