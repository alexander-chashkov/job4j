package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2019.02.18
 * ТЕСТЫ подсчет функций в диапазоне
 */
public class CalcTest {
    /**
     * тест линейной функции
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Calc calc = new Calc();
        List<Double> result = calc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    /**
     * тест квадратичной функции
     */
    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Calc calc = new Calc();
        List<Double> result = calc.diapason(2, 7, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(4D, 9D, 16D, 25D, 36D);
        assertThat(result, is(expected));
    }

    /**
     * тест логарифмической функции
     */
    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        Calc calc = new Calc();
        List<Double> result = calc.diapason(1, 5, x -> Math.round(Math.log(x) * 100D) / 100D);
        List<Double> expected = Arrays.asList(0D, 0.69D, 1.10D, 1.39D);
        assertThat(result, is(expected));
    }
}
