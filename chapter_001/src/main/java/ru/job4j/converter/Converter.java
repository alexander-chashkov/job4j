package ru.job4j.converter;

/**
 * Конвертор валюты.
 * Converter
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.11.12
 */


public class Converter {
    private final int euroRate = 70;
    private final int dollarRate = 60;

    /**
     * Конвертируем рубли в евро.
     *
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / this.euroRate;
    }

    /**
     * Конвертируем рубли в доллары.
     *
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / this.dollarRate;
    }

    /**
     * Конвертируем доллары в рубли.
     *
     * @param value доллары.
     * @return рубли
     */
    public int dollarToRuble(int value) {
        return value * this.dollarRate;
    }

    /**
     * Конвертируем евро в рубли.
     *
     * @param value евро рубли.
     * @return рубли.
     */
    public int euroToRuble(int value) {
        return value * this.euroRate;
    }
}