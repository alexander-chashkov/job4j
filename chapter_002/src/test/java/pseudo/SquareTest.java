package pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *  @version 0.0.0.1
 *  @since 2018.12.08
 *  @author Chashkov Alexander
 *  SquareTest
 */
public class SquareTest {
    /**
     * test for square.
     */
    @Test
    public void whenDrawSquare() {
        String sep = System.lineSeparator();
        Square square = new Square();
        StringBuilder expected = new StringBuilder();
        expected.append("█████████").append(sep);
        expected.append("█           █").append(sep);
        expected.append("█           █").append(sep);
        expected.append("█           █").append(sep);
        expected.append("█           █").append(sep);
        expected.append("█████████").append(sep);
        assertThat(square.draw(), is(expected.toString()));
    }
}