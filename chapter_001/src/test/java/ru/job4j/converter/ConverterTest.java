package ru.job4j.converter;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Тесты на конвертор валюты.
 * ConverterTest
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.11.12
 */
public class ConverterTest {

    /**
     *  test rubleToDollar
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(converter.dollarRate);
        int expected = 1;
        assertThat(result, is(expected));
    }

    /**
     * test dollarToRuble
     */
    @Test
    public void when5DollarToRubleThen300() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(5);
        int expected = 300;
        assertThat(result, is(expected));
    }

    /**
     * test rubleToEuro
     */
    @Test
    public void when140RubleToEuroThen2() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(140);
        int expected = 2;
        assertThat(result, is(expected));
    }

    /**
     * test euroToRuble
     */
    @Test
    public void when8EuroToRubleThen560() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(8);
        int expected = 560;
        assertThat(result, is(expected));
    }
}