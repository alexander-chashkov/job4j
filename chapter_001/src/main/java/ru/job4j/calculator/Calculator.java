package ru.job4j.calculator;

/**
 * Simple Calculator
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.11.11
 */
public class Calculator {
    private double result;

    /**
     * constructor
     */
    public Calculator() {
    }

    /**
     * addition
     * @param first addend
     * @param second addend
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * subtraction
     * @param first minuend
     * @param second subtrahend
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * multiplication
     * @param first multiplicand
     * @param second multiplier
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * division
     * @param first dividend
     * @param second divider
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * @return result
     */
    public double getResult() {
        return this.result;
    }
}
