package ru.job4j;

import org.junit.Test;
import ru.job4j.array.Check;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * class CheckTest
 * @version 0.0.0.1
 * @author Chashkov Alexander
 * @since 2018.11.24
 */
public class CheckTest {
    /**
     * test true
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * test false
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * test false one element
     */
    @Test
    public void whenDataMonoOneElement() {
        Check check = new Check();
        boolean[] input = new boolean[] {false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * test false four element
     */
    @Test
    public void whenDataNotMonoFourElement() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * test true five element
     */
    @Test
    public void whenDataMonoFiveElement() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * test true zero element
     */
    @Test
    public void whenDataMonoZeroElement() {
        Check check = new Check();
        boolean[] input = new boolean[] {};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * test false seven element
     */
    @Test
    public void whenDataMonoSevenElement() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, false, false, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}
