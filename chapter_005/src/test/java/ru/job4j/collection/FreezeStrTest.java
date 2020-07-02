package ru.job4j.collection;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 02.07.2020
 */
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class FreezeStrTest {
    @Test
    public void whenEq() {
        assertThat(FreezeStr.eq("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr.eq("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr.eq("heloo", "hello"), is(false));
    }
}
