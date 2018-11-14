package ru.job4j.condition;

import org.junit.Test;



import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Тесты на подсчет расстояния между точками.
 * PointTest
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.11.14
 */
public class PointTest {

    /**
     *  test distanceTo
     */
    @Test
    public void whenX0Y0andX5Y7() {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(5, 7);
        double result = pointA.distanceTo(pointB);
        double expected = 8.6;
        assertThat(result, closeTo(expected, 0.1));
    }

    /**
     *  test distanceTo
     */
    @Test
    public void whenX0Y0andX5Y0() {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(5, 0);
        double result = pointA.distanceTo(pointB);
        double expected = 5.0;
        assertThat(result, closeTo(expected, 0.01));
    }

}