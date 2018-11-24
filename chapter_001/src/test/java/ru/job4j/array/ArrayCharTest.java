package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *  тест обертки
 *  @version 0.0.0.1
 *  @author Chashkov Alexander
 *  @since 2018.11.24
 */
public class ArrayCharTest {
    /**
     * test Hello He
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }


    /**
     * test Hello Hi
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }


    /**
     * test Hello Helloddd
     */
    @Test
    public void whenNotStartWithPrefixThenFalse2() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Helloddd");
        assertThat(result, is(false));
    }

    /**
     * test Hello Hell
     */
    @Test
    public void whenNotStartWithPrefixThenTrue2() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hell");
        assertThat(result, is(true));
    }
}
