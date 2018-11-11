package ru.job4j.calculator;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
/**
 *	Test
 *	@author Alexander Chashkov
 *	@since 2018.11.11
 *	@version 0.0.0.1
 */
public class CalculatorTest {

    /**
     * test add
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * test add
     */
    @Test
    public void whenAdd25Plus2Then27() {
        Calculator calc = new Calculator();
        calc.add(25D, 2D);
        double result = calc.getResult();
        double expected = 27D;
        assertThat(result, is(expected));
    }

    /**
     * test subtract
     */
    @Test
    public void whenSubtractFiveMinusOneThenFour() {
        Calculator calc = new Calculator();
        calc.subtract(5D, 1D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }

    /**
     * test multiple
     */
    @Test
    public void whenMultipleTenAsteriskFiveThenFifty() {
        Calculator calc = new Calculator();
        calc.multiple(10D, 5D);
        double result = calc.getResult();
        double expected = 50D;
        assertThat(result, is(expected));
    }

    /**
     * test div
     */
    @Test
    public void whenDivTwentyTwoSlashTwoThenEleven() {
        Calculator calc = new Calculator();
        calc.div(22D, 2D);
        double result = calc.getResult();
        double expected = 11D;
        assertThat(result, is(expected));
    }

    /**
     * test getResult
     */
    @Test
    public void whenGetResultAfterOnePlusTwoThenThree() {
        Calculator calc = new Calculator();
        calc.add(1D, 2D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }
}