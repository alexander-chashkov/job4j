package ru.job4j.list;

import org.junit.Test;

        import static org.hamcrest.core.Is.is;
        import static org.hamcrest.Matchers.greaterThan;
        import static org.hamcrest.Matchers.lessThan;
        import static org.hamcrest.MatcherAssert.assertThat;
/**
 *  @version 0.0.0.1
 *  @since 2019.01.20
 *  @author Chashkov Alexander
 *  тесты для ListCompare
 */
public class StringsCompareTest {
    /**
     * тест 1 равные строки
     */
    @Test
    public void whenStringsAreEqualThenZero() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst, is(0));
    }

    /**
     * тест 2 правая строка больше то -1
     */
    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rst, lessThan(0));
    }

    /**
     * тест 3 левая строка больше то 1
     */
    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rst, greaterThan(0));
    }

    /**
     * тест 4 левая строка больше
     */
    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(rst, greaterThan(0));
    }

    /**
     * тест 5 правая строка больше
     */
    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rst, lessThan(0));
    }
}