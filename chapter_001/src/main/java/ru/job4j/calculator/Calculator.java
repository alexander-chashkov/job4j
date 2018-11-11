package ru.job4j.calculator;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.11.11
 */
public class Calculator {
    private double result;

    public Calculator() {
    }

    public void add(double first, double second) {
        this.result = first + second;
    }

    public void subtract(double first, double second) {
        this.result = first - second;
    }

    public void multiple(double first, double second) {
        this.result = first * second;
    }

    public void div(double first, double second) {
        this.result = first / second;
    }

    public double getResult() {
        return this.result;
    }
}
